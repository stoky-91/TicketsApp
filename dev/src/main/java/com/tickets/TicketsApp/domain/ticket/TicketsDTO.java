package com.tickets.TicketsApp.domain.ticket;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TicketsDTO {

    private String event;
    private String venue;
    private String dateEvent;
    private LocalDate datePurchase;
    private LocalDate dateSale;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private BigDecimal profit;
    private TypeOfTicketEnum TypeOfTicket;
    private PlatformSaleEnum platformSale;
    private LocalDate sendTo;
    private int numberOfTickets;
    private BigDecimal percentageProfit;
    private Boolean paid;
    private String email;

    public String getEvent() {
        return event;
    }

    public TicketsDTO setEvent(String event) {
        this.event = event;
        return this;
    }

    public String getVenue() {
        return venue;
    }

    public TicketsDTO setVenue(String venue) {
        this.venue = venue;
        return this;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public TicketsDTO setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
        return this;
    }

    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    public TicketsDTO setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
        return this;
    }

    public LocalDate getDateSale() {
        return dateSale;
    }

    public TicketsDTO setDateSale(LocalDate dateSale) {
        this.dateSale = dateSale;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public TicketsDTO setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public TicketsDTO setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public TicketsDTO setProfit(BigDecimal profit) {
        this.profit = profit;
        return this;
    }

    public TypeOfTicketEnum getTypeOfTicket() {
        return TypeOfTicket;
    }

    public TicketsDTO setTypeOfTicket(TypeOfTicketEnum typeOfTicket) {
        TypeOfTicket = typeOfTicket;
        return this;
    }

    public PlatformSaleEnum getPlatformSale() {
        return platformSale;
    }

    public TicketsDTO setPlatformSale(PlatformSaleEnum platformSale) {
        this.platformSale = platformSale;
        return this;
    }

    public LocalDate getSendTo() {
        return sendTo;
    }

    public TicketsDTO setSendTo(LocalDate sendTo) {
        this.sendTo = sendTo;
        return this;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public TicketsDTO setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        return this;
    }

    public BigDecimal getPercentageProfit() {
        return percentageProfit;
    }

    public TicketsDTO setPercentageProfit(BigDecimal percentageProfit) {
        this.percentageProfit = percentageProfit;
        return this;
    }

    public Boolean getPaid() {
        return paid;
    }

    public TicketsDTO setPaid(Boolean paid) {
        this.paid = paid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TicketsDTO setMail(String email) {
        this.email = email;
        return this;
    }


}
