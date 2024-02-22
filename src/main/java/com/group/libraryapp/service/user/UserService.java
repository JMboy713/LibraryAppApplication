package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
// Service :  controller 가 바꾼 객체를 그냥 받기만 한다.
// Service :  현재 유저가 있는지 없는지 확인하고 예외처리를 해준다.

public class UserService {
    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    public void updateUser(UserUpdateRequest request){

        if (userRepository.isUserNotExist( request.getId())) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(request.getId(), request.getName());
    }
    public void deleteUser(String name){

        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }

    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(), request.getAge());

    }

    public List<UserResponse> getUsers(){
        return userRepository.getUsers();
    }

}
