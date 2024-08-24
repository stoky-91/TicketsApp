package com.tickets.TicketsApp.domain.ticket;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
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


}
