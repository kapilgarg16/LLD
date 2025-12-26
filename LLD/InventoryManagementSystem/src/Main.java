import Enums.ProductCategory;
import Notification.InventoryObserver;
import Notification.NotificationImpl.SupplierNotifier;
import ProductsFactory.Product;
import ProductsFactory.ProductFactory;
import Replenishment.ReplenishmentImp.BulkOrderStrategy;
import Replenishment.ReplenishmentImp.JustInTimeStrategy;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of InventoryManager
        InventoryManager inventoryManager = InventoryManager.getInstance();
        InventoryObserver inventoryObserver = new SupplierNotifier("kapil garg", "kail@gmail.com");

        // Create and add warehouses
        Warehouse warehouse1 = new Warehouse("Warehouse 1");
        Warehouse warehouse2 = new Warehouse("Warehouse 2");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        inventoryManager.addObserver(inventoryObserver);

        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(
                ProductCategory.ELECTRONICS, "SKU123", "Laptop", 1000.0, 50, 5);
        Product tShirt = productFactory.createProduct(
                ProductCategory.CLOTHING, "SKU456", "T-Shirt", 20.0, 200, 5);
        Product apple = productFactory.createProduct(
                ProductCategory.GROCERY, "SKU789", "Apple", 1.0, 100, 5);

        inventoryManager.addProduct(15, laptop, warehouse1);
        inventoryManager.addProduct(20, tShirt, warehouse1);
        inventoryManager.addProduct(50, apple, warehouse2);

        inventoryManager.removeProduct(13, "SKU123", warehouse1);
        inventoryManager.removeProduct(48, "SKU789", warehouse2);

        // Set replenishment strategy to Just-In-Time
        inventoryManager.setReplenishmentStrategy(new JustInTimeStrategy());

        // Perform inventory check and replenish if needed
        inventoryManager.performInventoryCheck();

        // Switch replenishment strategy to Bulk Order
//        inventoryManager.setReplenishmentStrategy(new BulkOrderStrategy());
//
//        // Replenish a specific product if needed
//        inventoryManager.checkAndReplenish("SKU123");
    }
}
