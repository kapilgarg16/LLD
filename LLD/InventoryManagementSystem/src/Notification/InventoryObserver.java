package Notification;

import ProductsFactory.Product;

public interface InventoryObserver {
    void update(Product product);
}