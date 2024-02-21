package com.group.libraryapp.controller.user;

import com.group.libraryapp.domain.user.Fruit;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    //    private final List<User> users = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @PostMapping("/user")// post /user 로 데이터가 들어옴
    public void saveUser(@RequestBody UserCreateRequest request) {
        String sql = "Insert into user(name,age) Values(?,?)"; // ? -> jdbctemplate에 들어가는 값.
        jdbcTemplate.update(sql, request.getName(), request.getAge()); // update -> 값이 변겨오딘다. insert, update, delete 에 사용될 수 있다.

//        users.add(new User(request.getName(), request.getAge()));
        /* request 의 getName 과 getAge 로 json의 값을 읽어온다.
        해당 name과 age를 user의 생성자에 담아서 users list 에 담는다.
        * */

    }

//    @GetMapping("fruit")
//    public Fruit fruit(){
//        return new Fruit("바나나", 2000);
//    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        String sql = "Select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> { // user정보를 userResponse 로 바꾸어주는 역할.
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
//        List<UserResponse> responses = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//        return responses;
    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        String readSql = "Select * from user where id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId());
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "Update user set name = ? where id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        String sql = "Delete from user where name = ?";
        jdbcTemplate.update(sql, name);
    }


//    //error test
//    @GetMapping("user/error-test")
//    public void errorTest() {
//        throw new RuntimeException("에러 테스트");
//    }
}



