package com.shopping.app.dao;

import java.util.List;
import com.shopping.app.dto.Order;

public interface Order_Dao {

    Order getOrderById(int id);

    List<Order> getOrdersByCustomerId(int id);

    List<Order> getOrdersByPaymentType(String payment_type);

    List<Order> getAllOrders();

    void placeOrder(Order order);
}
