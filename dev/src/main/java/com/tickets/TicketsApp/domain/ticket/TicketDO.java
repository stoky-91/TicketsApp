package com.tickets.TicketsApp.domain.ticket;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class TicketDO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    @NotNull(message = "Field cannot be null")
    private String event;

    @Column
    //@NotNull(message = "Field cannot be null")
    private String venue;

    @Column
    //@NotNull(message = "Field cannot be null")
    private LocalDate dateEvent;

    @Column
    private LocalDate datePurchase;

    @Column
    private LocalDate dateSale;

    @Column(nullable = false)
    private BigDecimal purchasePrice = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal salePrice = BigDecimal.ZERO;

    @Column
    //@NotNull(message = "Field cannot be null")
    private BigDecimal profit = BigDecimal.ZERO;

    @Column
    private TypeOfTicketEnum typeOfTicket;

    @Column
    private PlatformSaleEnum platformSale;

    @Column
    private LocalDate sendTo;

    @Column
    private int numberOfTickets;

    @Column
    private BigDecimal percentageProfit;

    @Column
    //@NotNull(message = "Field cannot be null")
    private Boolean completed = false;

    @Column
    private String email;

    private int soldPerDays;

    @Column
    private String section;

    @Column(name = "`row`")
    private String row;

    @Column
    private String seat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Field cannot be null") String getEvent() {
        return event;
    }

    public void setEvent(@NotNull(message = "Field cannot be null") String event) {
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
