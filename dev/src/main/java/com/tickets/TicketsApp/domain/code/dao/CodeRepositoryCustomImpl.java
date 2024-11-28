package com.tickets.TicketsApp.domain.code.dao;

import com.tickets.TicketsApp.domain.code.CodeDO;
import com.tickets.TicketsApp.domain.code.CodeDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class CodeRepositoryCustomImpl implements CodeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public CodeDO updateCode(int codeId, CodeDTO updateDTO) {
        CodeDO code = entityManager.find(CodeDO.class, codeId);
        if (code == null) {
            throw new RuntimeException("Code not found with id: " + codeId);
        }

        if (updateDTO.getEvent() != null) {
            code.setEvent(updateDTO.getEvent());
        }
        if (updateDTO.getDateEvent() != null) {
            code.setDateEvent(updateDTO.getDateEvent());
        }
        if (updateDTO.getPrice() != null) {
            code.setPrice(updateDTO.getPrice());
        }
        if (updateDTO.getCount() != null) {
            code.setCount(updateDTO.getCount());
        }
        if (updateDTO.getNumberOfApplied() != null) {
            code.setNumberOfApplied(updateDTO.getNumberOfApplied());
        }
        if (updateDTO.getProvider() != null) {
            code.setProvider(updateDTO.getProvider());
        }
        if (updateDTO.getDescription() != null) {
            code.setDescription(updateDTO.getDescription());
        }

        return entityManager.merge(code);
    }
}
