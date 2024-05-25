package service.impl;

import exception.EcommerceException;
import model.Address;
import model.ErrorCode;
import model.Order;
import model.PaymentMode;
import repository.BuyerRepository;
import repository.OrderRepository;
import repository.PincodeServiceabilityRepository;
import repository.ProductRepository;
import service.BuyerService;
import service.OrderService;
import service.PinCodeService;
import service.ProductService;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ProductService productService;
    PinCodeService pinCodeService;
    BuyerService buyerService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductService productService, PinCodeService pinCodeService, BuyerService buyerService){
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.buyerService = buyerService;
        this.pinCodeService = pinCodeService;
    }

    //createPinCodeServiceability

    @Override
    public String addOrder(Order order) throws EcommerceException {
        Integer qu = order.getQuantity();
        String srcPin = productService.getProduct(order.getProductId()).getAddress().getPinCode();
        String destPin = buyerService.getBuyer(order.getBuyerId()).getAddress().getPinCode();

        //check first if pincode matches
        if(pinCodeService.checkIsSourceAndDestPinCodeMatchesForPaymentType(srcPin, destPin, order.getPaymentMode())){
            if(productService.checkProductInventory(order.getProductId(), qu)){
                orderRepository.createOrder(order);
            }
        }
        else{
            throw new EcommerceException(ErrorCode.PIN_CODE_UNSERVICEABLE, "Pincode_unserviceable");
        }
        return order.getOrderId();
    }

    @Override
    public Order getOrder(String orderId) {
        return orderRepository.getOrder(orderId);
    }
}
