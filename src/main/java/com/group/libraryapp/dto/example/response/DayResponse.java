package com.group.libraryapp.dto.example.response;

import java.time.DayOfWeek;

public class DayResponse {
    private String dayOfTheWeek;

    public DayResponse(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek.substring(0, 3);
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}

