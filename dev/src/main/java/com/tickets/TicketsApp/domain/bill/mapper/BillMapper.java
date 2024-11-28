package com.tickets.TicketsApp.domain.bill.mapper;

import com.tickets.TicketsApp.domain.bill.BillDO;
import com.tickets.TicketsApp.domain.bill.BillDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    BillDO dtoToDo(BillDTO billDTO);
    BillDTO doToDto(BillDO billDO);
}
