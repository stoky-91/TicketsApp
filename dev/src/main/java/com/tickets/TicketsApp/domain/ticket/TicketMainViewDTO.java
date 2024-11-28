package com.tickets.TicketsApp.domain.ticket;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TicketMainViewDTO {

    private Long id;
    private String event;
    private String venue;
    private LocalDate dateEvent;
    private LocalDate datePurchase;
    private LocalDate dateSale;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private BigDecimal profit;
    private TypeOfTicketEnum typeOfTicket;
    private PlatformSaleEnum platformSale;
    private LocalDate sendTo;
    private int numberOfTickets;
    private BigDecimal percentageProfit;
    private Boolean completed;
    private String email;

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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
    }

    public LocalDate getDateSale() {
        return dateSale;
    }

    public void setDateSale(LocalDate dateSale) {
        this.dateSale = dateSale;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public TypeOfTicketEnum getTypeOfTicket() {
        return typeOfTicket;
    }

    public void setTypeOfTicket(TypeOfTicketEnum typeOfTicket) {
        this.typeOfTicket = typeOfTicket;
    }

    public PlatformSaleEnum getPlatformSale() {
        return platformSale;
    }

    public void setPlatformSale(PlatformSaleEnum platformSale) {
        this.platformSale = platformSale;
    }

    public LocalDate getSendTo() {
        return sendTo;
    }

    public void setSendTo(LocalDate sendTo) {
        this.sendTo = sendTo;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigDecimal getPercentageProfit() {
        return percentageProfit;
    }

    public void setPercentageProfit(BigDecimal percentageProfit) {
        this.percentageProfit = percentageProfit;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
