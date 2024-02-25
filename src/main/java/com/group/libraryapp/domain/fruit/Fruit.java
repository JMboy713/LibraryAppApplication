package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20) // nullable = false : null 이 될 수 없다. varchar 20
    private String name;
    @Column(name="warehousing_date",nullable = false)
    private String warehousingDate;
    private long price;
    private boolean Sold;

    protected Fruit() {
    }
    public Fruit(String name, String warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
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

    public boolean Solden() {
        return Sold;
    }

    public void updatesold(boolean isSold) {
        this.Sold = isSold;
    }


}
