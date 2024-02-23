package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    //    private final List<User> users = new ArrayList<>();
//    private final JdbcTemplate jdbcTemplate;
    private final UserServiceV1 userServiceV1;

    public UserController(UserServiceV1 userServiceV1) {
        this.userServiceV1 = userServiceV1;
    }


    @PostMapping("/user")// post /user 로 데이터가 들어옴
    public void saveUser(@RequestBody UserCreateRequest request) {
        userServiceV1.saveUser(request);
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
        return userServiceV1.getUsers();
//        List<UserResponse> responses = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//        return responses;
    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userServiceV1.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userServiceV1.deleteUser(name);
    }


//    //error test
//    @GetMapping("user/error-test")
//    public void errorTest() {
//        throw new RuntimeException("에러 테스트");
//    }
}



