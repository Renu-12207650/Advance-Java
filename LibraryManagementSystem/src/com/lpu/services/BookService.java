package com.lpu.services;



import org.springframework.stereotype.Service;
import com.lpu.respository.BookRepository;
import com.lpu.model.Book;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private Long bookCounter = 1L;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author) {
        Book book = new Book(bookCounter++, title, author, true);
        bookRepository.addBook(book);
        System.out.println("Book Added Successfully!");
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.getBooks()
                .stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public Book findBook(Long id) {
        return bookRepository.findBookById(id);
    }
}