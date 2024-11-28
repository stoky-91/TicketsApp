package com.tickets.TicketsApp.domain.ticket.dao;

import com.tickets.TicketsApp.domain.ticket.TicketDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketDO, Long>, JpaSpecificationExecutor<TicketDO>, TicketRepositoryCustom {

}
