package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // 아래에 있는 함수가 시작될 떄 start transaction을 해준다.( 트랜잭션을 시작)
    // 함수가 예외 없이 끝났다면 commit
    // 혹시라도 문제가 있다면 rollback


    @Transactional
    public void saveUser(UserCreateRequest request){
        User u = userRepository.save(new User(request.getName(), request.getAge())); // JPA를 통해서 DB에 저장\
        //save 이후에는 id가 생성된다.
//        u.getId();// 1,2,3 과 같은 형식으로 데이터가 들어가게 된다.
//        throw new IllegalArgumentException();
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect((Collectors.toList()));
    }
    @Transactional
    public void updateUser(UserUpdateRequest request){
        // select * from user where id = ?
        // 결과 Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new); // 없다면 예외를 던져준다. 있다면 user 에 객체가 들어간다.
        user.updateName(request.getName());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name){
        //select * from user where name = ?
        User user = userRepository.findByName(name);// 결과값으로 user 가 나온다.
        if(user == null){
            throw new IllegalArgumentException();
        }
        userRepository.delete(user);

    }
}
