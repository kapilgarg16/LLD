
package repository;

import exception.EcommerceException;
import model.ErrorCode;
import model.Order;
//import utils.ErrorCodeMap;

import java.util.HashMap;

public class OrderRepository {
    HashMap<String, Order> orders;

    public OrderRepository(){
        orders = new HashMap<>();
    }

    public Order createOrder(Order order){
        if(orders.get(order.getOrderId())!=null){
            throw new EcommerceException(
                    ErrorCode.ORDER_CREATION_FAILED, "order already exist"
            );
        }
        orders.put(order.getOrderId(), order);
        return order;
    }

    public Order getOrder(String orderId) throws EcommerceException{
        if(orders.get(orderId) == null){
            throw new EcommerceException(ErrorCode.Order_does_not_exist, "order does not exist" );
        }
        return orders.get(orderId);
    }

}
