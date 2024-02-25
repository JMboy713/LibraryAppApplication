package com.group.libraryapp.controller.example;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.example.request.*;
import com.group.libraryapp.dto.example.response.*;
import com.group.libraryapp.service.fruit.FruitService;
import com.group.libraryapp.service.fruit.FruitServiceV2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ExampleController {
    //    public ExampleController(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
    private final FruitServiceV2 fruitService;

    public ExampleController(FruitServiceV2 fruitService) {
        this.fruitService = fruitService;
    }

    // 과제 - 문제 1.
    @GetMapping("/api/v1/calc")
    public CalculatorResponse calculator(CalculatorReqeust request) {
        return new CalculatorResponse(request); // 생성자에 request 넣어주기.
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayResponse dayResponse(@RequestParam("date") String date) {
        DayOfWeek dayOfWeek = LocalDate.parse(date).getDayOfWeek(); // SUNDAY 까지 나옴. LocalDate Type
        System.out.println(dayOfWeek.toString());

        return new DayResponse(dayOfWeek.toString());
    }

    @PostMapping("api/v1/sum")
    public int sum(@RequestBody SumRequest request) {
        return new SumResponse(request).getSum();
    }

//    @PostMapping("/multiply") // post /multiply
//    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {// body 안의 객체를 읽어온다.
//        return request.getNumber1() * request.getNumber2();
//    }

//    private final List<Fruit> fruits = new ArrayList<>();
//    private final JdbcTemplate jdbcTemplate;

    @PostMapping("api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request) {
        fruitService.saveFruit(request);
////        fruits.add(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
//        return new FruitResponse(fruits.get(fruits.size() - 1));

    }

    @PutMapping("api/v1/fruit")
    public void sellFruit(@RequestBody FruitUpdateRequest request) {
        fruitService.sellFruit(request);
    }

    @GetMapping("api/v1/fruit/stat")
    public FruitSoldResponse fruitSoldResponse(@RequestParam("name") String name) {
        return fruitService.getFruit(name);

    }

    @GetMapping("api/v1/fruit/count")
    public FruitCountResponse fruitCount(@RequestParam("name") String name) {
        return fruitService.getFruitCount(name);
    }

    @GetMapping("api/v1/fruit/list")
    public List<Fruit> fruitList(@RequestParam("price") long price, @RequestParam("option") String option) {
        return (List<Fruit>) fruitService.getFruits(option,price);
    }
}


