package com.tickets.TicketsApp.domain.code.dao;

import com.tickets.TicketsApp.domain.code.CodeDO;
import com.tickets.TicketsApp.domain.code.CodeDTO;
import com.tickets.TicketsApp.domain.ticket.TicketDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CodeRepository extends JpaRepository<CodeDO, Long>, CodeRepositoryCustom{
    @Query("SELECT COALESCE(SUM(c.price), 0) FROM CodeDO c")
    BigDecimal sumAllPrices();
}
