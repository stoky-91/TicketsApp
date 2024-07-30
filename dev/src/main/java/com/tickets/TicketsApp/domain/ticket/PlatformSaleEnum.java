package com.tickets.TicketsApp.domain.ticket;

public enum PlatformSaleEnum {

    VIAGOGO("Viagogo"),
    TICKETMASTER("TicketMaster"),
    TICKETSWAP("TicketSwap"),
    LYSTED("Lysted"),
    GIGSBERG("Gigsberg"),
    BAZOS("Bazos"),
    OTHER("Ostatní");

    private final String description;

    PlatformSaleEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
