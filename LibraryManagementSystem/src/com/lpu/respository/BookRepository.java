package com.lpu.respository;
import java.util.*;



import com.lpu.model.Book;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.lpu.model.Book;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
