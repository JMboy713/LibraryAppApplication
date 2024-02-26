package com.group.libraryapp.service.book;



import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.userloanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.userloanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookrepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookrepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookrepository = bookrepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    //    @Autowired
//    public void setBookrepository(Bookrepository bookrepository) {
//        this.bookrepository = bookrepository;
//    } // setter 와 autowired 로 의존성 주입.


    @Transactional
    public void saveBook(BookCreateRequest request ) {
        bookrepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
       // 1. 책 정보를 가져온다.

        Book book = bookrepository.findByName(request.getBookName()).orElseThrow(() -> new IllegalArgumentException("책이 존재하지 않습니다.")); // 예외처리
        //2.  대출정보를 확인해서 대출중인지 확인한다.
        // 3. 확인했는데 대출중이라면 예외를 발생시킨다.
        if(userLoanHistoryRepository.existsByBookNameAndIsReturned(book.getName(), false)) {
            throw new IllegalArgumentException("이미 대출중인 책입니다.");
        }
        // 4. 유저 정보를 가져온다.
        User user = userRepository.findByName(request.getUserName());
//                .orElseThrow(IllegalArgumentException::new);
        // 5. 유저 정보와 책 정보를 기반으로 UserLoanHistory 를 저장

        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        // 1. 책 정보를 가져온다.
        Book book = bookrepository.findByName(request.getBookName()).orElseThrow(() -> new IllegalArgumentException("책이 존재하지 않습니다.")); // 예외처리
        User user = userRepository.findByName(request.getUserName());
        // 2. 대출정보를 확인해서 대출중인지 확인한다.
        // 3. 확인했는데 대출중이 아니라면 예외를 발생시킨다.
        if (!userLoanHistoryRepository.existsByBookNameAndUserId(book.getName(), user.getId())) {
            throw new IllegalArgumentException("대출중인 책이 아닙니다.");
        }
        // 4. 대출정보를 가져온다.
        UserLoanHistory u = userLoanHistoryRepository.findByBookNameAndUserId(book.getName(), user.getId());
        // 5. 대출정보를 업데이트한다.
        u.returnBook(true);
        userLoanHistoryRepository.save(u);

    }



}
