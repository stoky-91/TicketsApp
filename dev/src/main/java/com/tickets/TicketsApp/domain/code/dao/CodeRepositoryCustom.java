package com.tickets.TicketsApp.domain.code.dao;

import com.tickets.TicketsApp.domain.bill.BillDTO;
import com.tickets.TicketsApp.domain.code.CodeDO;
import com.tickets.TicketsApp.domain.code.CodeDTO;

public interface CodeRepositoryCustom {

    CodeDO updateCode(int codeId, CodeDTO codeDTO);
}
