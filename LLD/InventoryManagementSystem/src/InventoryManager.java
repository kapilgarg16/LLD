import Notification.InventoryObserver;
import ProductsFactory.Product;
import ProductsFactory.ProductFactory;
import Replenishment.ReplenishmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    // Singleton instance
    private static InventoryManager instance;

    // System components
    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
    private ReplenishmentStrategy replenishmentStrategy;

    private List<InventoryObserver> observers;


    // Private constructor to prevent instantiation from outside
    private InventoryManager() {
        // Initialize collections and dependencies
        warehouses = new ArrayList<>();
        productFactory = new ProductFactory();
        observers = new ArrayList<>();

    }

    public void addProduct(int qty, Product product, Warehouse warehouse){
        warehouse.addProduct(product, qty);
    }

    public Product removeProduct(int qty, String sku, Warehouse warehouse){
        return warehouse.removeProduct(sku, qty);
    }

    // Static method to get the singleton instance with thread safety
    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Strategy pattern method
    public void setReplenishmentStrategy(ReplenishmentStrategy strategy) {
        this.replenishmentStrategy = strategy;
    }

    // Warehouse management
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    // Product inventory operations
    public Product getProductBySku(String sku) {
        for (Warehouse warehouse : warehouses) {
            Product product = warehouse.getProductBySku(sku);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

    // Check stock levels and apply replenishment strategy if needed
    public void checkAndReplenish(String sku) {
        Product product = getProductBySku(sku);
        if (product != null) {
            // If product is below threshold, notify observers
            if (product.getQuantity() < product.getThreshold()) {
                notifyObservers(product);
                // Apply current replenishment strategy
                if (replenishmentStrategy != null) {
                    replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    // Global inventory check
    public void performInventoryCheck() {
        for (Warehouse warehouse : warehouses) {
            for (Product product : warehouse.getAllProducts()) {
                if (product.getQuantity() < product.getThreshold()) {
                    notifyObservers(product);
                    if (replenishmentStrategy != null) {
                        replenishmentStrategy.replenish(product);
                    }
                }
            }
        }
    }

    // Observer pattern methods
    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(InventoryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Product product) {
        for (InventoryObserver observer : observers) {
            observer.update(product);
        }
    }
}
