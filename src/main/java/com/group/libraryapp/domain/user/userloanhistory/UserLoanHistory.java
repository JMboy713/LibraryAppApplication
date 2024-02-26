package com.group.libraryapp.domain.user.userloanhistory;

import com.group.libraryapp.dto.book.request.BookLoanRequest;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false,name="user_id")
    private long userId;

    @Column(nullable = false,name="book_name")
    private String bookName;

    @Column(nullable = false,name="is_returned")
    private boolean isReturned;

    protected UserLoanHistory() {
    }

    public UserLoanHistory(long userId, String bookName) {
        this.userId = userId;
        this.bookName = bookName;
        this.isReturned = false;
    }

    public void returnBook(boolean returned) {
        isReturned = returned;
    }
}
