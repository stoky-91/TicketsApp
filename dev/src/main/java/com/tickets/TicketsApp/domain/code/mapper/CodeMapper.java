package com.tickets.TicketsApp.domain.code.mapper;

import com.tickets.TicketsApp.domain.code.CodeDO;
import com.tickets.TicketsApp.domain.code.CodeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CodeMapper {

    CodeDO dtoToDo(CodeDTO codeDto);
    CodeDTO doToDto(CodeDO codeDO);
}
