package com.tickets.TicketsApp.domain.code;


import java.math.BigDecimal;
import java.time.LocalDate;

public class CodeDTO {

    private Long id;
    private String event;
    private LocalDate purchaseDate;
    private BigDecimal price;
    private Integer count;
    private Integer numberOfApplied;
    private String provider;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDate getDateEvent() {
        return purchaseDate;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.purchaseDate = dateEvent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getNumberOfApplied() {
        return numberOfApplied;
    }

    public void setNumberOfApplied(Integer numberOfApplied) {
        this.numberOfApplied = numberOfApplied;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
