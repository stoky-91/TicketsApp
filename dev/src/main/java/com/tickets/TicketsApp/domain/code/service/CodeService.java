package com.tickets.TicketsApp.domain.code.service;

import com.tickets.TicketsApp.domain.code.CodeDO;
import com.tickets.TicketsApp.domain.code.CodeDTO;
import com.tickets.TicketsApp.domain.code.CodeFilterDTO;
import com.tickets.TicketsApp.domain.code.dao.CodeRepository;
import com.tickets.TicketsApp.domain.code.mapper.CodeMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    private final CodeMapper codeMapper;

    @Autowired
    public CodeService(CodeRepository codeRepository, CodeMapper codeMapper) {
        this.codeRepository = codeRepository;
        this.codeMapper = codeMapper;
    }

    public List<CodeDTO> getAllCodes(){
        List<CodeDO> codeDOList = codeRepository.findAll();
        return codeDOList.stream()
                .map(codeMapper::doToDto) // mapování z CodeDO na CodeDTO
                .collect(Collectors.toList());
    }

    @Transactional
    public CodeDTO createCode(CodeDTO codeDTO){
        CodeDO codeDO = codeMapper.dtoToDo(codeDTO);
        CodeDO savedCode = codeRepository.save(codeDO);
        return codeMapper.doToDto(savedCode);
    }

    @Transactional
    public void deleteCode(Long id){
        codeRepository.deleteById(id);
    }

    @Transactional
    public CodeDTO updateCode(int codeId, CodeDTO codeDTO) {
        CodeDO updatedCode = codeRepository.updateCode(codeId, codeDTO);

        // Převedeme aktualizovaný Code na DTO pro vrácení
        return convertToCodeDTO(updatedCode);
    }

    private CodeDTO convertToCodeDTO(CodeDO codeDO) {
        return codeMapper.doToDto(codeDO);
    }

    public List<CodeDTO> filterCodes(CodeFilterDTO filter) {
        // Zde implementujeme filtrování pomocí CodeFilterDTO
        List<CodeDO> codeDOList = codeRepository.findAll().stream()
                .filter(code -> filter.getDateFrom() == null || !code.getDateEvent().isBefore(filter.getDateFrom()))
                .filter(code -> filter.getDateTo() == null || !code.getDateEvent().isAfter(filter.getDateTo()))
                .filter(code -> filter.getEvent() == null || code.getEvent().contains(filter.getEvent()))
                .filter(code -> filter.getPrice() == null || code.getPrice().equals(filter.getPrice()))
                .filter(code -> filter.getProvider() == null || code.getProvider().contains(filter.getProvider()))
                .collect(Collectors.toList());

        return codeDOList.stream()
                .map(codeMapper::doToDto)
                .collect(Collectors.toList());
    }
}
