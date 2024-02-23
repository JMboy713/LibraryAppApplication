package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
// Service :  controller 가 바꾼 객체를 그냥 받기만 한다.
// Service :  현재 유저가 있는지 없는지 확인하고 예외처리를 해준다.

@Service
public class UserServiceV1 {
    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }
    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }


    public void updateUser(UserUpdateRequest request){

        if (userJdbcRepository.isUserNotExist( request.getId())) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(request.getId(), request.getName());
    }

    public void deleteUser(String name){

        if (userJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userJdbcRepository.deleteUser(name);
    }

}
