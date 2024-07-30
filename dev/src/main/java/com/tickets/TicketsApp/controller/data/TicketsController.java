package com.tickets.TicketsApp.controller.data;

import com.tickets.TicketsApp.domain.ticket.TicketDetailDTO;
import com.tickets.TicketsApp.domain.ticket.TicketFilterDTO;
import com.tickets.TicketsApp.domain.ticket.TicketsDTO;
import com.tickets.TicketsApp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/data/tickets")
public class TicketsController {

    private TicketService ticketService;

    @Autowired
    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


//    @PostMapping
//    public TicketDetailDTO create(@RequestBody TicketDetailDTO dto) {
//        return ticketService.createTicket(dto);
//    }
//
//    @GetMapping
//    public List<TicketsDTO> getTicketByFilter(@RequestParam TicketFilterDTO filter) {
//        return ticketService.getTickets(filter);
//    }
//
//    @GetMapping("tickets-summary")
//    public TicketsSummary[] ticketsSummary(@RequestParam TicketFilterDTO filter) {
//        return ticketService.getSummaryRow(filter);
//    }
//
//    @GetMapping("{ticketId}")
//    public TicketDetailDTO show(@PathVariable Integer ticketId) {
//        return ticketService.getTicket(ticketId);
//    }
//
//    @DeleteMapping("{ticketId}")
//    public void deleteTicket(@PathVariable int ticketId) {
//        ticketService.deleteTicket(ticketId);
//    }


}
