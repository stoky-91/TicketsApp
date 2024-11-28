package com.tickets.TicketsApp.domain.code;

import com.tickets.TicketsApp.domain.PagingAndSortingFilter;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CodeFilterDTO {

    private String event;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private BigDecimal price;
    private String provider;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
