import Entities.*;
import Enums.*;
import Payment.*;

public class BookMyShowMain {
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.intialize();
        
        // Booking 1: User1 using UPI Payment
        Show show1 = bookMyShow.createBooking(City.DELHI, "Bahubali");
        if (show1 != null) {
            PaymentStrategy upiPayment = new UPIPayment("user@paytm");
            bookMyShow.bookSeat(show1, 10, upiPayment, "User1");
        }
        
        // Test: Try to book the same seat again for the SAME show (should fail - already booked)
        System.out.println("\n========== TESTING DOUBLE BOOKING PREVENTION ==========");
        if (show1 != null) {
            PaymentStrategy testPayment = new UPIPayment("test@paytm");
            System.out.println("Attempting to book seat 10 again for the same show...");
            bookMyShow.bookSeat(show1, 10, testPayment, "User2"); // This should fail - seat already booked
        }
        System.out.println("========================================================\n");
        
        // Test: Two users trying to book the same seat simultaneously (Seat Lock Test)
        System.out.println("\n========== TESTING SEAT LOCK MECHANISM ==========");
        Show show4 = bookMyShow.createBooking(City.DELHI, "Dangal");
        if (show4 != null) {
            System.out.println("Scenario: User3 and User4 both try to book seat 15 simultaneously");
            
            // User3 tries to book seat 15
            PaymentStrategy payment3 = new UPIPayment("user3@paytm");
            System.out.println("\n--- User3 attempting to book seat 15 ---");
            bookMyShow.bookSeat(show4, 15, payment3, "User3");
            
            // User4 tries to book the same seat 15 (should be blocked by lock)
            PaymentStrategy payment4 = new UPIPayment("user4@paytm");
            System.out.println("\n--- User4 attempting to book seat 15 (already locked by User3) ---");
            bookMyShow.bookSeat(show4, 15, payment4, "User4");
        }
        System.out.println("==================================================\n");
        
        // Booking 2: Using Credit Card Payment
        Show show2 = bookMyShow.createBooking(City.DELHI, "Dangal");
        if (show2 != null) {
            PaymentStrategy creditCardPayment = new UPIPayment("user5@paytm");
            bookMyShow.bookSeat(show2, 11, creditCardPayment, "User5");
        }

        // Booking 3: Using Wallet Payment
//        Show show3 = bookMyShow.createBooking(City.DELHI, "Bahubali");
//        if (show3 != null) {
//            PaymentStrategy walletPayment = new WalletPayment("Paytm");
//            bookMyShow.bookSeat(show3, 25, walletPayment, "User6");
//        }
    }
}

