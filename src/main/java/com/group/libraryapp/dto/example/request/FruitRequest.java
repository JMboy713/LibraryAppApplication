package com.group.libraryapp.dto.example.request;

import java.time.LocalDate;

public class FruitRequest {
    private String name;
    private String warehousingDate;
    private long price;

    public FruitRequest(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate.toString();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
