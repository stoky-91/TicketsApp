package com.tickets.TicketsApp.controller;

import com.tickets.TicketsApp.domain.ticket.*;
import com.tickets.TicketsApp.domain.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping
    public List<TicketMainViewDTO> getTicketsByFilter(@ModelAttribute TicketFilterDTO filter) {
        return ticketService.getTicketsByFilter(filter);
    }

    @GetMapping("{ticketId}")
    public TicketDetailDTO show(@PathVariable Integer ticketId) {
        return ticketService.getTicket(ticketId);
    }

    @PostMapping("/create")
    public ResponseEntity<TicketDetailDTO> createTicket(@RequestBody TicketDetailDTO ticketDetailDTO) {
        TicketDetailDTO newTicketDetailDTO = ticketService.createTicket(ticketDetailDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTicketDetailDTO);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketDetailDTO> updateTicket(@PathVariable("ticketId") int ticketId,
                                                        @RequestBody TicketDetailDTO ticketDetailDTO) {
            TicketDetailDTO updatedTicket = ticketService.updateTicket(ticketId, ticketDetailDTO);
            return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Ticket deleted succesfully");
    }

    @GetMapping("/tickets")
    public List<TicketMainViewDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket-summary")
    public TicketSummaryDTO getTicketSummary() {
        // Výpočet summary pro tickety s completed = false
        return ticketService.calculateTicketSummary();
    }
}
