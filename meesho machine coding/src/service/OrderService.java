package service;

import model.Order;

public interface OrderService {
    String addOrder(Order order);
    Order getOrder(String orderId);
}
