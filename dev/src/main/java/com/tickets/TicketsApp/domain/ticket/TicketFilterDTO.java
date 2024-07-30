package com.tickets.TicketsApp.domain.ticket;


import com.tickets.TicketsApp.domain.PagingAndSortingFilter;

import java.time.LocalDate;

public class TicketFilterDTO extends PagingAndSortingFilter {

    public enum DateType {
        EVENT,
        PURCHASE,
        SALE,
        SENDTO
    }

    public enum PlatformSale {
        VIAGOGO,
        TICKETMASTER,
        TICKETSWAP,
        LYSTED,
        GIGSBERG,
        BAZOS,
        OTHER
    }

    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer eventId;
    private Integer venueId;
    private DateType dateTypeId;
    private PlatformSale platformSaleId;
    private Boolean completed;

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public TicketFilterDTO setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public TicketFilterDTO setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public Integer getEventId() {
        return eventId;
    }

    public TicketFilterDTO setEventId(Integer eventId) {
        this.eventId = eventId;
        return this;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public TicketFilterDTO setVenueId(Integer venueId) {
        this.venueId = venueId;
        return this;
    }

    public DateType getDateTypeId() {
        return dateTypeId;
    }

    public TicketFilterDTO setDateTypeId(DateType dateTypeId) {
        this.dateTypeId = dateTypeId;
        return this;
    }

    public PlatformSale getPlatformSaleId() {
        return platformSaleId;
    }

    public TicketFilterDTO setPlatformSaleId(PlatformSale platformSaleId) {
        this.platformSaleId = platformSaleId;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public TicketFilterDTO setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }
}
