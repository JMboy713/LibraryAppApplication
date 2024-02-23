package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void saveUser(UserCreateRequest request){
        User u = userRepository.save(new User(request.getName(), request.getAge())); // JPA를 통해서 DB에 저장\
        //save 이후에는 id가 생성된다.
        u.getId();// 1,2,3 과 같은 형식으로 데이터가 들어가게 된다.
    }

    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect((Collectors.toList()));
    }

    public void updateUser(UserUpdateRequest request){
        // select * from user where id = ?
        // 결과 Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new); // 없다면 예외를 던져준다. 있다면 user 에 객체가 들어간다.
        user.updateName(request.getName());
        userRepository.save(user);
    }
}
