package com.hotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name="booking_details")
public class Booking {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int bookingId;

 @Column(nullable=false)
 private String customerName;

 private String roomType;
 private String checkInDate;
 private String checkOutDate;
 private double totalAmount;

 public Booking(){}

 public Booking(String customerName,String roomType,String checkInDate,String checkOutDate){
  this.customerName=customerName;
  this.roomType=roomType;
  this.checkInDate=checkInDate;
  this.checkOutDate=checkOutDate;
 }

 public int getBookingId(){return bookingId;}
 public void setBookingId(int bookingId){this.bookingId=bookingId;}
 public String getCustomerName(){return customerName;}
 public void setCustomerName(String customerName){this.customerName=customerName;}
 public String getRoomType(){return roomType;}
 public void setRoomType(String roomType){this.roomType=roomType;}
 public String getCheckInDate(){return checkInDate;}
 public void setCheckInDate(String checkInDate){this.checkInDate=checkInDate;}
 public String getCheckOutDate(){return checkOutDate;}
 public void setCheckOutDate(String checkOutDate){this.checkOutDate=checkOutDate;}
 public double getTotalAmount(){return totalAmount;}
 public void setTotalAmount(double totalAmount){this.totalAmount=totalAmount;}
}
