package com.tickets.TicketsApp.domain;

import lombok.Data;

@Data
public class PagingAndSortingFilter {
    private String orderBy;
    private boolean ascending;
    private long count;
    private long page;

    // Default constructor
    public PagingAndSortingFilter() {
        this.orderBy = null;
        this.ascending = false;
        this.count = 50;
        this.page = 0;
    }

    // Parameterized constructor
    public PagingAndSortingFilter(String orderBy, boolean ascending, long count, long page) {
        this.orderBy = orderBy;
        this.ascending = ascending;
        this.count = count;
        this.page = page;
    }
}
