package repository;

import exception.EcommerceException;
import model.ErrorCode;
import model.Product;
//import utils.ErrorCodeMap;

import java.util.HashMap;

public class ProductRepository {
    HashMap<String, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
    }

    public Product addProduct(Product product){
        if(products.get(product.getProductId()) != null){
            //throw run time exception
            throw new EcommerceException(ErrorCode.PRODUCT_ALREADY_CREATED, "product exist");
        }
        products.put(product.getProductId(), product);
        return product;
    }

    public Product getProduct(String productId) {
        if(products.get(productId) == null){
            throw new EcommerceException(ErrorCode.Product_doesnt_exist, "doesn't exist");
        }
        return products.get(productId);
    }

}