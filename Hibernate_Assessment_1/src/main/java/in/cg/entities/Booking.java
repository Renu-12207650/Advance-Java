package in.cg.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "booking_details")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private String customerName;

    private String roomType;

    private String checkInDate;
    private String checkOutDate;

    private double totalAmount;
    
    public Booking() {
    	
    }


    // Parameterized constructor
    public Booking(String customerName, String roomType, String checkInDate, String checkOutDate) {
        this.customerName = customerName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        calculateTotalAmount();
    }

    // Business Logic Method
    public void calculateTotalAmount() {

        String[] inParts = checkInDate.split("-");
        String[] outParts = checkOutDate.split("-");

        int inYear = Integer.parseInt(inParts[0]);
        int inMonth = Integer.parseInt(inParts[1]);
        int inDay = Integer.parseInt(inParts[2]);

        int outYear = Integer.parseInt(outParts[0]);
        int outMonth = Integer.parseInt(outParts[1]);
        int outDay = Integer.parseInt(outParts[2]);

        int days = outDay - inDay;
        
        if (days <= 0) {
            days = 1;
        }
        double pricePerDay = 0;

        switch (roomType) {
            case "Standard":
                pricePerDay = 2000;
                break;
            case "Deluxe":
                pricePerDay = 3500;
                break;
            case "Suite":
                pricePerDay = 5000;
                break;
            default:
                throw new IllegalArgumentException("Invalid Room Type");
        }

        this.totalAmount = days * pricePerDay;
    }


    // Getters and Setters
    public int getBookingId() { return bookingId; }

    public String getCustomerName() {
    	return customerName; 
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomType() { 
    	return roomType; 
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCheckInDate() { 
    	return checkInDate;
    }
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() { 
    	return checkOutDate; 
    }
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalAmount() {
    	return totalAmount; 
    }

    @Override
    public String toString() {
        return String.format(
            "Booking ID: %d | Customer: %s | Room: %s | Check-In: %s | Check-Out: %s | Total Amount: ₹%.2f",
            bookingId, customerName, roomType, checkInDate, checkOutDate, totalAmount
        );
    }

}
