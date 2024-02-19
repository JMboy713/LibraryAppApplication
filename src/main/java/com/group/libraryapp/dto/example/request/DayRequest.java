package com.group.libraryapp.dto.example.request;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DayRequest {


    private LocalDate date;

    public DayRequest(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
