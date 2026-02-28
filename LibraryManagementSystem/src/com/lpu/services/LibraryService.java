package com.lpu.services;



import org.springframework.stereotype.Service;
import com.lpu.model.Book;
import com.lpu.model.Member;

@Service
public class LibraryService {

    private final BookService bookService;
    private final MemberService memberService;

    public LibraryService(BookService bookService, MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public void issueBook(Long memberId, Long bookId) {

        Member member = memberService.findMember(memberId);
        Book book = bookService.findBook(bookId);

        if (member == null) {
        	 throw new RuntimeException("Member Not Found");
        }

        if (book == null) {
        	 throw new RuntimeException("Book Not Found");
            
        }

        if (!book.isAvailable()) {
        	 throw new RuntimeException("Book Already Issued!");
           
        }

        book.setAvailable(false);
        System.out.println("Book Issued Successfully!");
    }

    public void returnBook(Long memberId, Long bookId) {

        Book book = bookService.findBook(bookId);

        if (book == null) {
            System.out.println("Book Not Found!");
            return;
        }

        book.setAvailable(true);
        System.out.println("Book Returned Successfully!");
    }
}
