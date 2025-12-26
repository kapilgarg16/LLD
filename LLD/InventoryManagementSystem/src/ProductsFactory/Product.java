package ProductsFactory;

import Enums.ProductCategory;

public class Product {
    private String sku;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory category;

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
