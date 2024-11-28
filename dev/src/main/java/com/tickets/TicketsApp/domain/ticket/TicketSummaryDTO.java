package com.tickets.TicketsApp.domain.ticket;

import java.math.BigDecimal;

public class TicketSummaryDTO {

    private BigDecimal totalPurchasePrice;
    private BigDecimal totalSalePrice;
    private BigDecimal totalProfit;
    private Integer totalNumberOfTickets;
    private BigDecimal profitFromPayments;
    private BigDecimal profit;
    private BigDecimal percentageProfit;
    private BigDecimal actualPurchasePrice;

    public BigDecimal getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    public void setTotalPurchasePrice(BigDecimal totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }

    public BigDecimal getTotalSalePrice() {
        return totalSalePrice;
    }

    public void setTotalSalePrice(BigDecimal totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Integer getTotalNumberOfTickets() {
        return totalNumberOfTickets;
    }

    public void setTotalNumberOfTickets(Integer totalNumberOfTickets) {
        this.totalNumberOfTickets = totalNumberOfTickets;
    }

    public BigDecimal getProfitFromPayments() {
        return profitFromPayments;
    }

    public void setProfitFromPayments(BigDecimal profitFromPayments) {
        this.profitFromPayments = profitFromPayments;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getPercentageProfit() {
        return percentageProfit;
    }

    public void setPercentageProfit(BigDecimal percentageProfit) {
        this.percentageProfit = percentageProfit;
    }

    public BigDecimal getActualPurchasePrice() {
        return actualPurchasePrice;
    }

    public void setActualPurchasePrice(BigDecimal actualPurchasePrice) {
        this.actualPurchasePrice = actualPurchasePrice;
    }
}
