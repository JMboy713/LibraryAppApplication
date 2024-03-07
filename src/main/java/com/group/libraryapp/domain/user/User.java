package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.userloanhistory.UserLoanHistory;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 스프링이 User 객체와 user 테이블을 같은 것으로 바라보게 한다.
@NoArgsConstructor // 기본생성자 생성해줌.(access level 을 protected 로 설정하면 외부에서 생성자를 호출할 수 없다.)
public class User {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id=null; // long == BIGINT
    @Column(nullable = false, length = 20) // name 은 null 이 될 수 없고, name varchar(20) 으로 설정 ,name="name" 이라고 해도 되지만 생략 가능
    private String name;
    // column 생략 가능.
    private Integer age;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true) // 연관관계의 주인이 아닌 user 쪽에 mappedBy 를 설정해야 한다.
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();


    // 기본 생성자가 필요하다


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

    public void loanBook(String bookName) {
        userLoanHistories.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("대여한 책(%s)이 없습니다.", bookName)));
        targetHistory.returnBook(true);
    }


}
