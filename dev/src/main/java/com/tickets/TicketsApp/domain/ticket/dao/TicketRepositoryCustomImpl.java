package com.tickets.TicketsApp.domain.ticket.dao;

import com.tickets.TicketsApp.domain.ticket.TicketDO;
import com.tickets.TicketsApp.domain.ticket.TicketDetailDTO;
import com.tickets.TicketsApp.domain.ticket.TicketFilterDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class TicketRepositoryCustomImpl implements TicketRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TicketDO> findByFilter(TicketFilterDTO filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TicketDO> query = cb.createQuery(TicketDO.class);
        Root<TicketDO> root = query.from(TicketDO.class);

        Predicate predicate = cb.conjunction();

        if (filter.getEvent() != null && !filter.getEvent().isEmpty()) {
            predicate = cb.and(predicate, cb.equal(root.get("event"), filter.getEvent()));
        }

        if (filter.getVenue() != null && !filter.getVenue().isEmpty()) {
            predicate = cb.and(predicate, cb.equal(root.get("venue"), filter.getVenue()));
        }

        if (filter.getDateFrom() != null && filter.getDateTo() != null) {
            switch (filter.getDateType()) {
                case EVENT:
                    predicate = cb.and(predicate, cb.between(root.get("dateEvent"), filter.getDateFrom(), filter.getDateTo()));
                    break;
                case PURCHASE:
                    predicate = cb.and(predicate, cb.between(root.get("datePurchase"), filter.getDateFrom(), filter.getDateTo()));
                    break;
                case SALE:
                    predicate = cb.and(predicate, cb.between(root.get("dateSale"), filter.getDateFrom(), filter.getDateTo()));
                    break;
                case SENDTO:
                    predicate = cb.and(predicate, cb.between(root.get("sendTo"), filter.getDateFrom(), filter.getDateTo()));
                    break;
            }
        }

        if (filter.getPlatformSale() != null) {
            predicate = cb.and(predicate, cb.equal(root.get("platformSale"), filter.getPlatformSale().name()));
        }

        query.where(predicate);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Optional<TicketDO> findById(int ticketId) {
        return Optional.ofNullable(entityManager.find(TicketDO.class, ticketId));
    }

    @Override
    public TicketDO findByIdAndUpdate(int ticketId, TicketDetailDTO ticketDetailDTO) {
        return null;
    }

    @Override
    public List<TicketDO> findByCompletedFalse() {
        return List.of();
    }

    @Override
    public List<TicketDO> findByCompletedTrue() {
        return List.of();
    }

    @Transactional
    public TicketDO updateTicket(int ticketId, TicketDetailDTO updateDTO) {
        TicketDO ticket = entityManager.find(TicketDO.class, ticketId);
        if (ticket == null) {
            throw new EntityNotFoundException("Ticket with ID " + ticketId + " not found");
           }

        // Aktualizace Ticketu
        if (updateDTO.getEvent() != null) {
            ticket.setEvent(updateDTO.getEvent());
        }
        if (updateDTO.getVenue() != null) {
            ticket.setVenue(updateDTO.getVenue());
        }
        if (updateDTO.getDateEvent() != null) {
            ticket.setDateEvent(updateDTO.getDateEvent());
        }
        if (updateDTO.getDatePurchase() != null) {
            ticket.setDatePurchase(updateDTO.getDatePurchase());
        }
        if (updateDTO.getDateSale() != null) {
            ticket.setDateSale(updateDTO.getDateSale());
        }
        if (updateDTO.getSalePrice() != null){
        ticket.setSalePrice(updateDTO.getSalePrice());
        }
        if (updateDTO.getPurchasePrice() != null){
            ticket.setPurchasePrice(updateDTO.getPurchasePrice());
        }
        if (updateDTO.getSendTo() != null) {
            ticket.setSendTo(updateDTO.getSendTo());
        }

        // Vrátíme aktualizovaný Ticket
        return entityManager.merge(ticket);
    }
}
