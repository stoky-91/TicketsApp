package com.tickets.TicketsApp.domain.ticket;


import com.tickets.TicketsApp.domain.PagingAndSortingFilter;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
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

    private Long id;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String event;
    private String venue;
    private DateType dateType;
    private PlatformSale platformSale;
    private Boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public DateType getDateType() {
        return dateType;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    public PlatformSale getPlatformSale() {
        return platformSale;
    }

    public void setPlatformSale(PlatformSale platformSale) {
        this.platformSale = platformSale;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
