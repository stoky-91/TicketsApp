package com.tickets.TicketsApp.domain.ticket;

public class TicketDetailDTO extends TicketsDTO{

    private int soldPerDays;
    private String section;
    private String row;
    private String seat;

    public int getSoldPerDays() {
        return soldPerDays;
    }

    public TicketDetailDTO setSoldPerDays(int soldPerDays) {
        this.soldPerDays = soldPerDays;
        return this;
    }

    public String getSection() {
        return section;
    }

    public TicketDetailDTO setSection(String section) {
        this.section = section;
        return this;
    }

    public String getRow() {
        return row;
    }

    public TicketDetailDTO setRow(String row) {
        this.row = row;
        return this;
    }

    public String getSeat() {
        return seat;
    }

    public TicketDetailDTO setSeat(String seat) {
        this.seat = seat;
        return this;
    }



}
