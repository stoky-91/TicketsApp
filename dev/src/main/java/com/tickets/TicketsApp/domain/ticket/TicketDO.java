package com.tickets.TicketsApp.domain.ticket;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class TicketDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String event;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private LocalDate dateEvent;

    @Column
    private LocalDate datePurchase;

    @Column
    private LocalDate dateSale;

    @Column
    private int soldPerDays;

    @Column(nullable = false)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private BigDecimal salePrice;

    @Column(nullable = false)
    private BigDecimal profit;


    private TypeOfTicketEnum TypeOfTicket;


    private PlatformSaleEnum platformSale;

    @Column
    private LocalDate sendTo;

    @Column
    private String section;

    @Column
    private String row;

    @Column
    private String seat;

    private Boolean paid;

    @Column
    private int numberOfTickets;

    @Column(nullable = false)
    private BigDecimal percentageProfit;

    @Column
    private String email;

}
