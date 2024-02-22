package com.group.libraryapp.domain.user;

import java.time.LocalDate;

public class Fruit {
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
