package com.lpu.main;



import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.config.JavaConfFile;
import com.lpu.services.*;

public class LibraryApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfFile.class);

        BookService bookService = context.getBean(BookService.class);
        MemberService memberService = context.getBean(MemberService.class);
        LibraryService libraryService = context.getBean(LibraryService.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("LIBRARY MENU");
            System.out.println("1. Register Member");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    memberService.registerMember(name, email);
                    break;

                case 2:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    bookService.addBook(title, author);
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    Long memberId = sc.nextLong();
                    System.out.print("Enter Book ID: ");
                    Long bookId = sc.nextLong();
                    libraryService.issueBook(memberId, bookId);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    Long mId = sc.nextLong();
                    System.out.print("Enter Book ID: ");
                    Long bId = sc.nextLong();
                    libraryService.returnBook(mId, bId);
                    break;

                case 5:
                    bookService.getAvailableBooks()
                            .forEach(book ->
                                    System.out.println(book.getId() + " - " + book.getTitle()));
                    break;

                case 6:
                    context.close();
                    System.out.println("Application Closed");
                    return;
            }
        }
    }
}