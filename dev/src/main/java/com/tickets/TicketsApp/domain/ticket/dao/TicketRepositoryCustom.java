package com.tickets.TicketsApp.domain.ticket.dao;

import com.tickets.TicketsApp.domain.ticket.TicketDO;
import com.tickets.TicketsApp.domain.ticket.TicketDetailDTO;
import com.tickets.TicketsApp.domain.ticket.TicketFilterDTO;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface TicketRepositoryCustom {

    List<TicketDO> findByFilter(TicketFilterDTO filter);
    Optional<TicketDO> findById(int ticketId);
    TicketDO findByIdAndUpdate(int ticketId, TicketDetailDTO ticketDetailDTO);
    List<TicketDO> findByCompletedFalse();
    List<TicketDO> findByCompletedTrue();
}
