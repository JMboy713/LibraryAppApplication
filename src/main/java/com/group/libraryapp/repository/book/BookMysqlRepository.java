package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary // 의존성에서 우선순위를 가짐.
@Repository
public class BookMysqlRepository implements Bookrepository{
    @Override
    public void saveBook() {
        System.out.println("mysql");

    }
}
