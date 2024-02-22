package com.group.libraryapp.dto.example.response;

import com.group.libraryapp.domain.user.Fruit;
import com.group.libraryapp.dto.example.request.FruitRequest;

public class FruitResponse {
    private String name;
    private String warehousingDate;
    private long price;

    public FruitResponse(Fruit fruit) {
        this.name = fruit.getName();
        this.warehousingDate = fruit.getWarehousingDate().toString();
        this.price = fruit.getPrice();
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
