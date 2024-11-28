package com.tickets.TicketsApp.domain.bill;

import java.math.BigDecimal;

public class BillSummaryDTO {
    private BigDecimal totalPrice;

    public BillSummaryDTO(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
