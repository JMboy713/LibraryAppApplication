package com.group.libraryapp.dto.example.response;

import com.group.libraryapp.dto.example.request.CalculatorReqeust;

public class CalculatorResponse {
    private int add;
    private int minus;
    private int multiply;

    public CalculatorResponse(CalculatorReqeust calculatorReqeust) {
        this.add = calculatorReqeust.getNum1()+ calculatorReqeust.getNum2();
        this.minus = calculatorReqeust.getNum1()+ calculatorReqeust.getNum2();
        this.multiply = calculatorReqeust.getNum1()* calculatorReqeust.getNum2();
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }
}
