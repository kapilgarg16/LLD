package service;

import model.Product;

public interface ProductService {
    String addProduct(Product product);
    Product getProduct(String id);
    boolean checkProductInventory(String productId, Integer amount);
}
