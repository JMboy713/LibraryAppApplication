package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {
    private String name;
    private Integer age; // int => null 을 표현할 수 없다. Integer -> null 표현이 가능하다.

    public String getName() {
        return name;
    }



    public Integer getAge() {
        return age;
    }

}
