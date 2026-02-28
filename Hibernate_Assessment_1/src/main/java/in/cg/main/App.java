package in.cg.main;

import in.cg.dao.BookingDAO;
import in.cg.entities.Booking;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        BookingDAO dao = new BookingDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Room Type (Standard/Deluxe/Suite): ");
                    String roomType = sc.nextLine();

                    System.out.print("Enter Check-In Date (yyyy-MM-dd): ");
                    String checkIn = sc.nextLine();

                    System.out.print("Enter Check-Out Date (yyyy-MM-dd): ");
                    String checkOut = sc.nextLine();

                    Booking booking = new Booking(name, roomType, checkIn, checkOut);
                    dao.addBooking(booking);
                    System.out.println("Booking Added Successfully!");
                    break;

                case 2:
                    List<Booking> bookings = dao.getAllBookings();
                    bookings.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Booking ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("1. Update Customer Name");
                    System.out.println("2. Update Room Type");
                    System.out.println("3. Update Check-In Date");
                    System.out.println("4. Update Check-Out Date");
                    System.out.println("5. Update All");
                    System.out.print("Enter choice: ");

                    int updateChoice = sc.nextInt();
                    sc.nextLine();

                    dao.updateBooking(id, updateChoice, sc);
                    break;


                case 4:
                    System.out.print("Enter Booking ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteBooking(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
