package com.group.libraryapp.dto.example.request;

public class FruitUpdateRequest {
    private int id;
    private String name;
    private String warehousingDate;
    private long price;

    public int getId() {
        return id;
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
