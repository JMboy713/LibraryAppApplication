package com.group.libraryapp.dto.example.request;

import java.util.List;

public class SumRequest {
    private List<Integer> numbers;

    public SumRequest() {

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
