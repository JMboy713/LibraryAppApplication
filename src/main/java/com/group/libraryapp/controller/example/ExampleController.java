package com.group.libraryapp.controller.example;

import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.example.request.CalculatorReqeust;
import com.group.libraryapp.dto.example.request.DayRequest;
import com.group.libraryapp.dto.example.request.SumRequest;
import com.group.libraryapp.dto.example.response.CalculatorResponse;
import com.group.libraryapp.dto.example.response.DayResponse;
import com.group.libraryapp.dto.example.response.SumResponse;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ExampleController {
    // 과제 - 문제 1.
    @GetMapping("/api/v1/calc")
    public CalculatorResponse calculator(CalculatorReqeust request){
        return new CalculatorResponse(request); // 생성자에 request 넣어주기.
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayResponse dayResponse(@RequestParam("date") String date){
        DayOfWeek dayOfWeek = LocalDate.parse(date).getDayOfWeek(); // SUNDAY 까지 나옴. LocalDate Type
        System.out.println(dayOfWeek.toString());

        return new DayResponse(dayOfWeek.toString());
    }

    @PostMapping("api/v1/sum")
    public int sum(@RequestBody SumRequest request){
        return new SumResponse(request).getSum();
    }

//    @PostMapping("/multiply") // post /multiply
//    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {// body 안의 객체를 읽어온다.
//        return request.getNumber1() * request.getNumber2();
//    }
}
