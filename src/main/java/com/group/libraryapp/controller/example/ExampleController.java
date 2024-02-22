package com.group.libraryapp.controller.example;

import com.group.libraryapp.dto.example.request.*;
import com.group.libraryapp.dto.example.response.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ExampleController {
    public ExampleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

//    private final List<Fruit> fruits = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    @PostMapping("api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request){
        String sql = "Insert into fruit(name, warehousingDate, price,sold) Values(?,?,?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice(),false);
////        fruits.add(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
//        return new FruitResponse(fruits.get(fruits.size() - 1));

    }

    @PutMapping("api/v1/fruit")
    public void sellFruit(@RequestBody FruitUpdateRequest request) {
        String sql = "update fruit set sold = ? where id = ?";
        jdbcTemplate.update(sql, true,request.getId());
    }

    @GetMapping("api/v1/fruit/stat")
    public List<FruitSoldResponse> fruitSoldResponse(@RequestParam("name") String name){
        String sql ="select"+
                "(select sum(price) from fruit where sold = 1) as salesAmount, " +
                "(select sum(price) from fruit where sold = 0) as notSalesAmount";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long salesAmount = rs.getLong("salesAmount");
            long notSalesAmount = rs.getLong("notSalesAmount");
            return new FruitSoldResponse(salesAmount, notSalesAmount);
        });
    }




}


