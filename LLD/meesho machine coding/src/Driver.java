import exception.EcommerceException;
import model.*;
import repository.BuyerRepository;
import repository.OrderRepository;
import repository.PincodeServiceabilityRepository;
import repository.ProductRepository;
import service.BuyerService;
import service.OrderService;
import service.PinCodeService;
import service.ProductService;
import service.impl.BuyerServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.PinCodeServiceImpl;
import service.impl.ProductServiceImpl;

public class Driver {
    public static void main(String[] args) {
        BuyerRepository buyerRepository = new BuyerRepository();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        PincodeServiceabilityRepository pincodeServiceabilityRepository = new PincodeServiceabilityRepository();

        BuyerService buyerService = new BuyerServiceImpl(buyerRepository);
        ProductService productService = new ProductServiceImpl(productRepository);
        PinCodeService pinCodeService = new PinCodeServiceImpl(pincodeServiceabilityRepository);
        OrderService orderService = new OrderServiceImpl(orderRepository, productService, pinCodeService, buyerService);

        //create Address
        Address address1 = new Address("baseri","Agra",  "328022");
        Address address2 = new Address("dholpur", "Delhi", "424242");
        Address address3 = new Address("Bari", "Mumbai", "12123");
        Address address4 = new Address("Timasiya", "Bangalore", "302022");

        Product product1 = new Product("shoes", 10, address1);
        Product product2 = new Product("Jeans", 5, address2);

        String productId1 = productService.addProduct(product1);
        String productId2 = productService.addProduct(product2);
//
        Buyer buyer1 = new Buyer("Kapil", address3);
        Buyer buyer2 = new Buyer("Chirag", address4);

        String buyerId1 = buyerService.addBuyer(buyer1);
        String buyerId2 = buyerService.addBuyer(buyer2);

        pinCodeService.createPinCodeServiceability("328022", "12123", PaymentMode.COD);
        pinCodeService.createPinCodeServiceability("424242", "302022", PaymentMode.Prepaid);


        Order order1 = new Order(productId1, buyerId1, 5, PaymentMode.Prepaid);
        Order order2 = new Order(productId2, buyerId2, 4, PaymentMode.Prepaid);
//

        try{
            orderService.addOrder(order1);
            System.out.println("Order placed successfull");
        }
        catch (EcommerceException e){
            System.out.println(e.getErrorCode() + " " +  e.getErrorMessage());
        }



    }
}
