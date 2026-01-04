package Payment;

public class WalletPayment implements PaymentStrategy {
    private String walletType;
    
    public WalletPayment(String walletType) {
        this.walletType = walletType;
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing " + walletType + " Wallet Payment...");
        System.out.println("Amount: Rs. " + amount);
        // Simulate payment processing
        System.out.println("Payment successful via " + walletType + " Wallet!");
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return walletType + " Wallet";
    }
}

