package com.tickets.TicketsApp.domain.ticket.mapper;

import com.tickets.TicketsApp.domain.ticket.TicketDO;
import com.tickets.TicketsApp.domain.ticket.TicketDetailDTO;
import com.tickets.TicketsApp.domain.ticket.TicketMainViewDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketDetailMapper {

    TicketDO dtoToDo(TicketDetailDTO ticketDetailDTO);
    TicketDetailDTO doToDto(TicketDO ticketDO);

    TicketMainViewDTO doToMainViewDto(TicketDO ticketDO);
    TicketDO mainViewDtoToDo(TicketMainViewDTO ticketsMainViewDTO);

}
