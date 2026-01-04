package Payment;

public class UPIPayment implements PaymentStrategy {
    private String upiId;
    
    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing UPI Payment...");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount: Rs. " + amount);
        // Simulate payment processing
        System.out.println("Payment successful via UPI!");
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "UPI";
    }
}

