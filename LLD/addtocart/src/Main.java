import Service.CartService;
import models.Product;
import models.User;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("P001", "Laptop", 1000);
        Product product2 = new Product("P002", "Smartphone", 700);

        // Create a user
        User user = new User("U001", "Kapil");

        // Create a CartService
        CartService cartService = new CartService();

        // Add items to the cart
        cartService.addToCart(user, product1, 1);
        cartService.addToCart(user, product2, 2);

        // View cart
        cartService.viewCart(user);

        // Remove an item
        cartService.removeFromCart(user, "P002");

        // View cart again
        cartService.viewCart(user);
    }
}