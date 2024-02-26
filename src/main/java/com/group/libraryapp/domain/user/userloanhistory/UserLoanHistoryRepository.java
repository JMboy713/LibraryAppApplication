package com.group.libraryapp.domain.user.userloanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    // select * from user_loan_history where book_name = ? and is_returned = ?;
    boolean existsByBookNameAndIsReturned(String bookName,boolean isReturned);
    boolean existsByBookNameAndUserId(String bookName, Long userId);
    UserLoanHistory findByBookNameAndUserId(String bookName, Long userId);

}
