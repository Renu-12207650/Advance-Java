package com.lpu.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.config.JavaConfFile;
import com.lpu.services.*;

class LibraryTest {

    static AnnotationConfigApplicationContext context;
    static BookService bookService;
    static MemberService memberService;
    static LibraryService libraryService;

    @BeforeAll
    static void setup() {

        context = new AnnotationConfigApplicationContext(JavaConfFile.class);

        bookService = context.getBean(BookService.class);
        memberService = context.getBean(MemberService.class);
        libraryService = context.getBean(LibraryService.class);

       
        memberService.registerMember("Esha", "esha@mail.com");
        bookService.addBook("Atomic Habits", "James Clear");
    }

    //  SUCCESS CASE
    @Test
    void testIssueBookSuccess() {

        assertDoesNotThrow(() ->
                libraryService.issueBook(1L, 1L));
    }

    //  INVALID MEMBER
    @Test
    void testIssueBookInvalidMember() {

        assertThrows(RuntimeException.class, () ->
                libraryService.issueBook(99L, 1L));

        
    }

   
    @Test
    void testIssueBookInvalidBook() {

        assertThrows(RuntimeException.class, () ->
                libraryService.issueBook(1L, 99L));

        
    }

    //  BOOK ALREADY ISSUED
    @Test
    void testIssueAlreadyIssuedBook() {

        libraryService.issueBook(1L, 1L); 

         assertThrows(RuntimeException.class, () ->
                libraryService.issueBook(1L, 1L));


    }

    //  RETURN INVALID BOOK
    @Test
    void testReturnInvalidBook() {

      assertThrows(RuntimeException.class, () ->
                libraryService.returnBook(1L, 99L));


    }

    @AfterAll
    static void tearDown() {
        context.close();
    }
}