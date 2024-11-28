package com.tickets.TicketsApp.domain.bill.service;

import com.tickets.TicketsApp.domain.bill.BillDO;
import com.tickets.TicketsApp.domain.bill.BillDTO;
import com.tickets.TicketsApp.domain.bill.BillFilterDTO;
import com.tickets.TicketsApp.domain.bill.dao.BillRepository;
import com.tickets.TicketsApp.domain.bill.mapper.BillMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    private final BillRepository billRepository;

    private final BillMapper billMapper;

    @Autowired
    public BillService(BillRepository billRepository, BillMapper billMapper) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
    }

    public List<BillDTO> getAllBills() {
        List<BillDO> billDOList = billRepository.findAll();
        return billDOList.stream()
                .map(billMapper::doToDto) // mapování z BillDO na BillDTO
                .collect(Collectors.toList());
    }

    @Transactional
    public BillDTO createBill(BillDTO billDTO){
        BillDO billDO = billMapper.dtoToDo(billDTO);
        BillDO savedBill = billRepository.save(billDO);
        return billMapper.doToDto(savedBill);
    }

    @Transactional
    public void deleteBill(Long id){
        billRepository.deleteById(id);
    }

    @Transactional
    public BillDTO updateBill(int billId, BillDTO billDTO) {
        BillDO updatedBill = billRepository.updateBill(billId, billDTO);

        // Převedeme aktualizovaný Ticket na DTO pro vrácení
        return convertToBillDTO(updatedBill);
    }

    private BillDTO convertToBillDTO(BillDO billDO) {
        return billMapper.doToDto(billDO);
    }

    public List<BillDTO> filterBills(BillFilterDTO filter) {
        // Zde implementujeme filtrování pomocí BillFilterDTO
        List<BillDO> billDOList = billRepository.findAll().stream()
                .filter(bill -> filter.getDateFrom() == null || !bill.getDate().isBefore(filter.getDateFrom()))
                .filter(bill -> filter.getDateTo() == null || !bill.getDate().isAfter(filter.getDateTo()))
                .filter(bill -> filter.getDescription() == null || bill.getDescription().contains(filter.getDescription()))
                .toList();

        return billDOList.stream()
                .map(billMapper::doToDto)
                .collect(Collectors.toList());
    }
}
