package com.tickets.TicketsApp.domain.bill.dao;

import com.tickets.TicketsApp.domain.bill.BillDO;
import com.tickets.TicketsApp.domain.bill.BillDTO;

public interface BillRepositoryCustom {

    BillDO updateBill(int billId, BillDTO billDTO);
}
