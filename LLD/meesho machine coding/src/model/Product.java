
package model;

import java.util.UUID;

public class Product {
    private final String productId;
    private final String productName;
    private int productQuantity;
    private final Address address; //where the product belong

    public Product(String productName, int productQuantity, Address address) {
        this.productId = UUID.randomUUID().toString();
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.address = address;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Address getAddress() {
        return address;
    }
}
