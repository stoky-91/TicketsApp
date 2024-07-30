package com.tickets.TicketsApp.domain;

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

    // Getters and Setters
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

}
