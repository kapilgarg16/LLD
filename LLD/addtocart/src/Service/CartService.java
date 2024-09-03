package Service;

import models.Cart;
import models.CartItem;
import models.Product;
import models.User;

public class CartService {

    public void addToCart(User user, Product product, int quantity) {
        Cart cart = user.getCart();
        cart.addItem(product, quantity);
        System.out.println(quantity + " " + product.getName() + "(s) added to cart.");
    }

    public void removeFromCart(User user, String productId) {
        Cart cart = user.getCart();
        cart.removeItem(productId);
        System.out.println("Product with ID " + productId + " removed from cart.");
    }

    public void viewCart(User user) {
        Cart cart = user.getCart();
        System.out.println("Cart Items for user " + user.getName() + ":");
        for (CartItem item : cart.getItems().values()) {
            System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity() + ", Total Price: " + item.getTotalPrice());
        }
        System.out.println("Total Cart Amount: " + cart.getTotalAmount());
    }
}
