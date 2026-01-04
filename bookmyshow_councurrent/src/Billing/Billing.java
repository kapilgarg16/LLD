package Billing;

import Entities.Seats;
import Payment.Payment;
import Payment.PaymentStrategy;

import java.util.List;

public class Billing {
    private static int paymentIdCounter = 1000;
    
    public double calculateTotalAmount(List<Seats> bookedSeats) {
        double totalAmount = 0.0;
        System.out.println("\n========== BILLING CALCULATION ==========");
        System.out.println("Seat Details:");
        for (Seats seat : bookedSeats) {
            System.out.println("  Seat " + seat.getId() + " (" + seat.getSeatType() + 
                             ") - Rs. " + seat.getPriceForSeat());
            totalAmount += seat.getPriceForSeat();
        }
        System.out.println("Total Amount: Rs. " + totalAmount);
        System.out.println("==========================================\n");
        return totalAmount;
    }
    
    public Payment processPayment(double amount, PaymentStrategy paymentStrategy) {
        int paymentId = generatePaymentId();
        Payment payment = new Payment(paymentId, amount, paymentStrategy);
        payment.processPayment();
        return payment;
    }
    
    private int generatePaymentId() {
        return paymentIdCounter++;
    }
}

