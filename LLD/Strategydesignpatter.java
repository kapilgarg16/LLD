package withoutstrategy;

public class PaymentProcessor {
    private PaymentType paymentType;

    public void processPayment(double amount) {
        if (paymentType == PaymentType.CREDIT_CARD) {
            System.out.println("Processing credit card payment of amount " + amount);
        } else if (paymentType == PaymentType.DEBIT_CARD) {
            System.out.println("Processing debit card payment of amount " + amount);
        } else if (paymentType == PaymentType.PAYPAL) {
            System.out.println("Processing PayPal payment of amount " + amount);
        } else {
            throw new IllegalArgumentException("Invalid payment type");
        }
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}

enum PaymentType {
    CREDIT_CARD,
    DEBIT_CARD,
    PAYPAL
}


-------

package withstrategy;

public interface PaymentStrategy {
    void processPayment(double amount);
}

package withstrategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of amount " + amount);
    }
}

package withstrategy;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of amount " + amount);
    }
}

package withstrategy;

public class PaypalPaymentStrategy implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of amount " + amount);
    }
}

package withstrategy;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

//https://www.freecodecamp.org/news/a-beginners-guide-to-the-strategy-design-pattern/
