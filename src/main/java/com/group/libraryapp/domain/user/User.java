package com.group.libraryapp.domain.user;

import javax.persistence.*;

@Entity // 스프링이 User 객체와 user 테이블을 같은 것으로 바라보게 한다.
public class User {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id=null; // long == BIGINT
    @Column(nullable = false, length = 20) // name 은 null 이 될 수 없고, name varchar(20) 으로 설정 ,name="name" 이라고 해도 되지만 생략 가능
    private String name;
    // column 생략 가능.
    private Integer age;

    // 기본 생성자가 필요하다
    protected User() {
    }

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어 왔습니다. ", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
