package com.tickets.TicketsApp.domain.bill.dao;

import com.tickets.TicketsApp.domain.bill.BillDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BillRepository extends JpaRepository<BillDO, Long>, BillRepositoryCustom {

    @Query("SELECT COALESCE(SUM(b.price), 0) FROM BillDO b")
    BigDecimal sumAllPrices();

}
