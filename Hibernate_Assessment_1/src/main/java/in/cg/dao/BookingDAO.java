package in.cg.dao;

import in.cg.config.HibernateUtil;
import in.cg.entities.Booking;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class BookingDAO {

    public void addBooking(Booking booking) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        booking.calculateTotalAmount();
        session.persist(booking);

        tx.commit();
        session.close();
    }

    public List<Booking> getAllBookings() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> list = session.createQuery("from Booking", Booking.class).list();
        session.close();
        return list;
    }

    public void updateBooking(int id, int choice, Scanner sc) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Booking booking = session.get(Booking.class, id);

        if (booking != null) {

            switch (choice) {

                case 1:
                    System.out.print("Enter new Customer Name: ");
                    String newName = sc.nextLine();
                    booking.setCustomerName(newName);
                    break;

                case 2:
                    System.out.print("Enter new Room Type (Standard/Deluxe/Suite): ");
                    String newRoom = sc.nextLine();
                    booking.setRoomType(newRoom);
                    break;

                case 3:
                    System.out.print("Enter new Check-In Date (yyyy-MM-dd): ");
                    String newCheckIn = sc.nextLine();
                    booking.setCheckInDate(newCheckIn);
                    break;

                case 4:
                    System.out.print("Enter new Check-Out Date (yyyy-MM-dd): ");
                    String newCheckOut = sc.nextLine();
                    booking.setCheckOutDate(newCheckOut);
                    break;

                case 5:
                    System.out.print("Enter new Customer Name: ");
                    booking.setCustomerName(sc.nextLine());

                    System.out.print("Enter new Room Type (Standard/Deluxe/Suite): ");
                    booking.setRoomType(sc.nextLine());

                    System.out.print("Enter new Check-In Date (yyyy-MM-dd): ");
                    booking.setCheckInDate(sc.nextLine());

                    System.out.print("Enter new Check-Out Date (yyyy-MM-dd): ");
                    booking.setCheckOutDate(sc.nextLine());
                    break;

                default:
                    System.out.println("Invalid update choice!");
            }

            booking.calculateTotalAmount();

            System.out.println("Booking Updated Successfully!");

        } else {
            System.out.println("Booking not found!");
        }

        tx.commit();
        session.close();
    }


    public void deleteBooking(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Booking booking = session.get(Booking.class, id);
        if (booking != null) {
            session.remove(booking);
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Booking not found!");
        }

        tx.commit();
        session.close();
    }
}
