package com.group.libraryapp.service.book;

import com.group.libraryapp.repository.book.BookMysqlRepository;
import com.group.libraryapp.repository.book.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final Bookrepository bookrepository;

//    @Autowired
//    public void setBookrepository(Bookrepository bookrepository) {
//        this.bookrepository = bookrepository;
//    } // setter 와 autowired 로 의존성 주입.
        public BookService(Bookrepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    public void saveBook() {
        // Save book
    }
}
