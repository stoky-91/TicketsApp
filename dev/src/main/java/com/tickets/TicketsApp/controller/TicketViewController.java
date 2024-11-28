package com.tickets.TicketsApp.controller;

import com.tickets.TicketsApp.domain.ticket.TicketFilterDTO;
import com.tickets.TicketsApp.domain.ticket.TicketMainViewDTO;
import com.tickets.TicketsApp.domain.ticket.TicketSummaryDTO;
import com.tickets.TicketsApp.domain.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketViewController {

    private final TicketService ticketService;

    @Autowired
    public TicketViewController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Zobrazení HTML stránky s tabulkou
    @GetMapping
    public String showTickets(Model model) {
        List<TicketMainViewDTO> tickets = ticketService.getAllTickets();
        BigDecimal totalPrice = tickets.stream()
                .map(TicketMainViewDTO::getSalePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("tickets", tickets);
        model.addAttribute("summary", new TicketSummaryDTO(totalPrice));
        model.addAttribute("filter", new TicketFilterDTO());
        return "ticket"; // Název Thymeleaf šablony (ticket.html)
    }

    // Zpracování filtru a zobrazení filtrovaných dat
    @GetMapping("/filter")
    public String filterTickets(@ModelAttribute TicketFilterDTO filter, Model model) {
        List<TicketMainViewDTO> filteredTickets = ticketService.filterTickets(filter);
        BigDecimal totalPrice = filteredTickets.stream()
                .map(TicketMainViewDTO::getSalePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("tickets", filteredTickets);
        model.addAttribute("summary", new TicketSummaryDTO(totalPrice));
        model.addAttribute("filter", filter);
        return "ticket"; // Název Thymeleaf šablony (ticket.html)
    }
}