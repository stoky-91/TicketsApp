package com.tickets.TicketsApp.domain.ticket.service;

import com.tickets.TicketsApp.domain.bill.dao.BillRepository;
import com.tickets.TicketsApp.domain.code.dao.CodeRepository;
import com.tickets.TicketsApp.domain.ticket.*;
import com.tickets.TicketsApp.domain.ticket.dao.TicketRepository;
import com.tickets.TicketsApp.domain.ticket.mapper.TicketDetailMapper;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketDetailMapper ticketDetailMapper;

    private final BillRepository billRepository;

    private final CodeRepository codeRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketDetailMapper ticketDetailMapper, BillRepository billRepository, CodeRepository codeRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketDetailMapper = ticketDetailMapper;
        this.billRepository = billRepository;
        this.codeRepository = codeRepository;
    }

    @Transactional
    public TicketDetailDTO createTicket(TicketDetailDTO ticketDetailDTO) {
        TicketDO ticket = ticketDetailMapper.dtoToDo(ticketDetailDTO);
        ticket.setProfit(calculateProfit(ticketDetailDTO));
        ticket.setPercentageProfit(calculatePercentageProfit(ticketDetailDTO));
        TicketDO savedTicket = ticketRepository.save(ticket);
        return ticketDetailMapper.doToDto(savedTicket);
    }

    @Transactional
    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }

    public List<TicketMainViewDTO> getTicketsByFilter(TicketFilterDTO filter) {
        List<TicketDO> tickets = ticketRepository.findByFilter(filter);
        return tickets.stream().map(this::convertToView).collect(Collectors.toList());
    }

    @Transactional
    public TicketDetailDTO updateTicket(int ticketId, TicketDetailDTO ticketDetailDTO) {
        // Aktualizujeme Ticket prostřednictvím vlastního repozitáře
        TicketDO updatedTicket = ticketRepository.findByIdAndUpdate(ticketId, ticketDetailDTO);

        // Převedeme aktualizovaný Ticket na DTO pro vrácení
        return convertToTicketDetailDTO(updatedTicket);
    }

    public TicketDetailDTO getTicket(Integer ticketId) {
        Optional<TicketDO> optionalTicket = ticketRepository.findById(ticketId.longValue());

        if (optionalTicket.isPresent()) {
            TicketDO ticket = optionalTicket.get();
            return ticketDetailMapper.doToDto(ticket);
        } else {
            // Můžete zde hodit výjimku, pokud tiket s daným ID neexistuje
            throw new RuntimeException("Ticket with ID " + ticketId + " not found.");
        }
    }

    public List<TicketMainViewDTO> getAllTickets(){
        List<TicketDO> ticketDOList = ticketRepository.findAll();
        return ticketDOList.stream()
                .map(ticketDetailMapper::doToDto) // mapování z BillDO na BillDTO
                .collect(Collectors.toList());
    }

    public TicketSummaryDTO calculateTicketSummary() {
        // Získáme všechny tickety z databáze, kde completed = false
        List<TicketDO> tickets = ticketRepository.findByCompletedFalse();

        int incompleteTicketsCount = tickets.size();
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (TicketDO ticket : tickets) {
            if (ticket.getPurchasePrice() != null) {
                totalPrice = totalPrice.add(ticket.getPurchasePrice());
            }
        }

        List<TicketDO> completedTickets = ticketRepository.findByCompletedTrue();
        BigDecimal totalProfit = BigDecimal.ZERO;
        for (TicketDO ticket : completedTickets) {
            if (ticket.getProfit() != null) {
                totalProfit = totalProfit.add(ticket.getProfit());
            }
        }

        TicketSummaryDTO summary = new TicketSummaryDTO();
        summary.setTotalNumberOfTickets(incompleteTicketsCount);
        summary.setTotalPurchasePrice(totalPrice);
        summary.setTotalProfit(totalProfit);
        return summary;
    }

    public BigDecimal calculateTotalProfit() {
        // 1. Součet všech profitů z TicketDO
        List<TicketDO> tickets = ticketRepository.findAll();
        BigDecimal totalProfit = BigDecimal.ZERO;
        for (TicketDO ticket : tickets) {
            if (ticket.getProfit() != null) {
                totalProfit = totalProfit.add(ticket.getProfit());
            }
        }

        // 2. Součet všech cen z BillDO
        BigDecimal totalBillPrice = billRepository.sumAllPrices();

        // 3. Součet všech cen z CodeDO
        BigDecimal totalCodePrice = codeRepository.sumAllPrices();

        // 4. Výpočet celkového zisku = totalProfit - totalBillPrice - totalCodePrice
        return totalProfit.subtract(totalBillPrice).subtract(totalCodePrice);
    }

    public BigDecimal calculateProfit(TicketDetailDTO ticketDetailDTO) {
        BigDecimal result = ticketDetailDTO.getSalePrice() != null ? ticketDetailDTO.getSalePrice().subtract(ticketDetailDTO.getPurchasePrice()) : BigDecimal.ZERO.subtract(ticketDetailDTO.getPurchasePrice());
        return result;
   }

    public static BigDecimal calculatePercentageProfit(TicketDetailDTO ticketDetailDTO){
        BigDecimal salePrice = ticketDetailDTO.getSalePrice() != null ? ticketDetailDTO.getSalePrice() : BigDecimal.ZERO;
        BigDecimal calculateRatio = salePrice.divide(ticketDetailDTO.getPurchasePrice(), 2, RoundingMode.HALF_UP);
       BigDecimal multipliedRatio = calculateRatio.multiply(new BigDecimal("100"));
        return multipliedRatio.subtract(new BigDecimal("100"));
    }

    private TicketMainViewDTO convertToView(TicketDO ticketDO) {
       return ticketDetailMapper.doToMainViewDto(ticketDO);
    }

    private TicketDetailDTO convertToTicketDetailDTO(TicketDO ticket) {
        return ticketDetailMapper.doToDto(ticket);
    }

}
