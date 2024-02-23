package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// SQL 을 통해 실제 DB와의 통신을 담당한다.
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id){
        String readSql = "Select * from user where id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }
    public void updateUserName(long id, String name){
        String sql = "Update user set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public boolean isUserNotExist(String name){
        String readSql = "Select * from user where name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty(); // rowMapper 를 람다로 받음 -> rowMapper 는 ResultSet 을 받아서 원하는 객체로 변환해주는 역할을 한다.
    }
    public void deleteUser(String name){
        String sql = "Delete from user where name = ?";
        jdbcTemplate.update(sql, name);
    }
    public void saveUser(String name,Integer age){
        String sql = "Insert into user(name,age) Values(?,?)"; // ? -> jdbctemplate에 들어가는 값.
        jdbcTemplate.update(sql, name,age); // update -> 값이 변겨오딘다. insert, update, delete 에 사용될 수 있다.
    }

    public List<UserResponse> getUsers(){
        String sql = "Select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> { // user정보를 userResponse 로 바꾸어주는 역할.
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

}
