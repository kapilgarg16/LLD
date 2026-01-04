package Payment;

import java.util.Date;

public class Payment {
    private int paymentId;
    private double amount;
    private PaymentStrategy paymentStrategy;
    private Date paymentDate;
    private boolean isPaymentSuccessful;
    
    public Payment(int paymentId, double amount, PaymentStrategy paymentStrategy) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
        this.paymentDate = new Date();
        this.isPaymentSuccessful = false;
    }
    
    public boolean processPayment() {
        System.out.println("\n========== PAYMENT PROCESSING ==========");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Payment Method: " + paymentStrategy.getPaymentMethod());
        isPaymentSuccessful = paymentStrategy.processPayment(amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("========================================\n");
        return isPaymentSuccessful;
    }
    
    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }
    
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public Date getPaymentDate() {
        return paymentDate;
    }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }
    
    public void setPaymentSuccessful(boolean paymentSuccessful) {
        isPaymentSuccessful = paymentSuccessful;
    }
}

