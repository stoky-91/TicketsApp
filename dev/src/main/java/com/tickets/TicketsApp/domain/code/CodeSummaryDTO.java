package com.tickets.TicketsApp.domain.code;

import java.math.BigDecimal;

public class CodeSummaryDTO {
    private BigDecimal totalPrice;

    public CodeSummaryDTO(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
