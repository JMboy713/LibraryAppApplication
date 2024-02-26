package com.group.libraryapp.domain.user.userloanhistory;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.book.request.BookLoanRequest;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne
    private User user;

    @Column(nullable = false,name="book_name")
    private String bookName;

    @Column(nullable = false,name="is_returned")
    private boolean isReturned;

    protected UserLoanHistory() {
    }
    public UserLoanHistory(User user, String bookName) {

        this.user = user;
        this.bookName = bookName;
        this.isReturned = false;
    }

    public String getBookName() {
        return bookName;
    }

    public void returnBook(boolean returned) {
        isReturned = returned;
    }


}
