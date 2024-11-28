package com.tickets.TicketsApp.domain.ticket;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class TicketDetailDTO extends TicketMainViewDTO {

    private int soldPerDays;
    private String section;
    private String row;
    private String seat;

    public int getSoldPerDays() {
        return soldPerDays;
    }

    public void setSoldPerDays(int soldPerDays) {
        this.soldPerDays = soldPerDays;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
