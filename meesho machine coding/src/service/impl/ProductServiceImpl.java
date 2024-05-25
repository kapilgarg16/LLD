package service.impl;

import exception.EcommerceException;
import model.ErrorCode;
import model.Product;
import repository.ProductRepository;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public String addProduct(Product product) throws EcommerceException {
        productRepository.addProduct(product);
        return product.getProductId();
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.getProduct(id);
    }

    @Override
    public boolean checkProductInventory(String productId, Integer amount) {
        Product product = getProduct(productId);
        if(product.getProductQuantity() >= amount){
            product.setProductQuantity(product.getProductQuantity() - amount);
            return true;
        }
        else {
            throw new EcommerceException(ErrorCode.IN_SUFFICIENT_INVENTORY, "insufficent_inventory");
        }
    }
}
