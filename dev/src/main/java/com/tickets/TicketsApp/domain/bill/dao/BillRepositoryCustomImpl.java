package com.tickets.TicketsApp.domain.bill.dao;

import com.tickets.TicketsApp.domain.bill.BillDO;
import com.tickets.TicketsApp.domain.bill.BillDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class BillRepositoryCustomImpl implements BillRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public BillDO updateBill(int billId, BillDTO updateDTO) {
        BillDO bill = entityManager.find(BillDO.class, billId);
        if (bill == null) {
            throw new RuntimeException("Bill not found with id: " + billId);
        }

        if (updateDTO.getDate() != null) {
            bill.setDate(updateDTO.getDate());
        }
        if (updateDTO.getPrice() != null) {
            bill.setPrice(updateDTO.getPrice());
        }
        if (updateDTO.getDescription() != null) {
            bill.setDescription(updateDTO.getDescription());
        }

        return entityManager.merge(bill);
    }
}
