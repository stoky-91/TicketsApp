package com.tickets.TicketsApp.domain.ticket;

public enum TypeOfTicketEnum {
    E_TICKET("E-Ticket"),
    MOBILE_TICKET("Mobile-ticket");

    private final String description;

    TypeOfTicketEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
