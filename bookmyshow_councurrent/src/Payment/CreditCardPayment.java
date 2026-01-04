package Payment;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    
    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: ****" + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Amount: Rs. " + amount);
        // Simulate payment processing
        System.out.println("Payment successful via Credit Card!");
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

