package com.hotel.main;

import com.hotel.dao.BookingDAO;
import com.hotel.entity.Booking;

public class MainApp {

 public static void main(String[] args) {

  BookingDAO dao=new BookingDAO();

  Booking b=new Booking("Sonu","Deluxe","2026-02-10","2026-02-12");
  dao.addBooking(b);

  dao.viewAll().forEach(x->System.out.println(x.getCustomerName()));

  dao.updateBooking(1,"Suite");

  dao.deleteBooking(1);
 }
}
