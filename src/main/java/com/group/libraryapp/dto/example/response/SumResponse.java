package com.group.libraryapp.dto.example.response;

import com.group.libraryapp.dto.example.request.SumRequest;

public class SumResponse {
    private int sum;

    public SumResponse(SumRequest sumRequest) {
        int i=0;
        for (Object o : sumRequest.getNumbers()) {
            i += (int) o;
            System.out.println(i);
        }
        this.sum=i;
    }

    public int getSum() {
        return sum;
    }
}
