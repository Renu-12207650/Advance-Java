package com.hotel.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hotel.entity.Booking;
import com.hotel.util.HibernateUtil;

public class BookingDAO {

 private double calculateAmount(String roomType,String in,String out){
  long days=ChronoUnit.DAYS.between(LocalDate.parse(in),LocalDate.parse(out));
  double price=0;

  if(roomType.equalsIgnoreCase("Standard")) price=2000;
  else if(roomType.equalsIgnoreCase("Deluxe")) price=3500;
  else if(roomType.equalsIgnoreCase("Suite")) price=5000;
  else throw new IllegalArgumentException();

  return days*price;
 }

 public void addBooking(Booking b){
  b.setTotalAmount(calculateAmount(b.getRoomType(),b.getCheckInDate(),b.getCheckOutDate()));
  Session s=HibernateUtil.getSessionFactory().openSession();
  Transaction tx=s.beginTransaction();
  s.persist(b);
  tx.commit();
  s.close();
 }

 public List<Booking> viewAll(){
  Session s=HibernateUtil.getSessionFactory().openSession();
  List<Booking> list=s.createQuery("from Booking",Booking.class).list();
  s.close();
  return list;
 }

 public void updateBooking(int id,String newRoom){
  Session s=HibernateUtil.getSessionFactory().openSession();
  Transaction tx=s.beginTransaction();
  Booking b=s.get(Booking.class,id);
  b.setRoomType(newRoom);
  b.setTotalAmount(calculateAmount(newRoom,b.getCheckInDate(),b.getCheckOutDate()));
  s.merge(b);
  tx.commit();
  s.close();
 }

 public void deleteBooking(int id){
  Session s=HibernateUtil.getSessionFactory().openSession();
  Transaction tx=s.beginTransaction();
  Booking b=s.get(Booking.class,id);
  s.remove(b);
  tx.commit();
  s.close();
 }
}
