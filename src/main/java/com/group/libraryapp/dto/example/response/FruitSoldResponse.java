package com.group.libraryapp.dto.example.response;

public class FruitSoldResponse {
    private long salesAmount;
    private long notsalesAmount;

    public FruitSoldResponse(long salesAmount, long notsalesAmount) {
        this.salesAmount = salesAmount;
        this.notsalesAmount = notsalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(long salesAmount) {
        this.salesAmount = salesAmount;
    }

    public long getNotsalesAmount() {
        return notsalesAmount;
    }

    public void setNotsalesAmount(long notsalesAmount) {
        this.notsalesAmount = notsalesAmount;
    }
}
