package Ticket;

import Entities.Booking;
import Entities.Seats;
import Entities.Show;
import Payment.Payment;

import java.util.List;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private Booking booking;
    private Payment payment;
    
    public  Ticket(Booking booking, Payment payment) {
        this.ticketId = generateTicketId();
        this.booking = booking;
        this.payment = payment;
    }
    
    private String generateTicketId() {
        return "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    
    public void printTicket() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                    BOOK MY SHOW TICKET                      ║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║ Ticket ID: " + String.format("%-47s", ticketId) + "║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        
        Show show = booking.getShow();
        System.out.println("║ Movie: " + String.format("%-52s", show.getMovie().getMovieName()) + "║");
        System.out.println("║ Show Time: " + String.format("%-49s", show.getLocalTime()) + "║");
        System.out.println("║ Screen: " + String.format("%-51s", "Screen " + show.getScreen().getId()) + "║");
        
        List<Seats> seats = booking.getBookingSeat();
        System.out.println("║ Seats: " + String.format("%-52s", getSeatNumbers(seats)) + "║");
        
        double totalAmount = 0.0;
        for (Seats seat : seats) {
            totalAmount += seat.getPriceForSeat();
        }
        System.out.println("║ Total Amount: " + String.format("%-45s", "Rs. " + totalAmount) + "║");
        System.out.println("║ Payment Method: " + String.format("%-44s", payment.getPaymentStrategy().getPaymentMethod()) + "║");
        System.out.println("║ Payment Status: " + String.format("%-44s", payment.isPaymentSuccessful() ? "SUCCESS" : "FAILED") + "║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("            Thank you for booking with BookMyShow!            \n");
    }
    
    private String getSeatNumbers(List<Seats> seats) {
        StringBuilder seatNumbers = new StringBuilder();
        for (int i = 0; i < seats.size(); i++) {
            seatNumbers.append(seats.get(i).getId());
            if (i < seats.size() - 1) {
                seatNumbers.append(", ");
            }
        }
        return seatNumbers.toString();
    }
    
    // Getters
    public String getTicketId() {
        return ticketId;
    }
    
    public Booking getBooking() {
        return booking;
    }
    
    public Payment getPayment() {
        return payment;
    }
}

