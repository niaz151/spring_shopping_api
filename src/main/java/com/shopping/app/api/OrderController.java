package com.shopping.app.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.shopping.app.dao.Order_Dao;
import com.shopping.app.dto.Order;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    Order_Dao order_dao;

    public OrderController(@Qualifier("Order_Dao")Order_Dao order_dao){
        this.order_dao = order_dao;
    }

    @GetMapping(path="/getOrderById/{id}")
    public Order getOrderById(@PathVariable("id") int id){
        return order_dao.getOrderById(id);
    }

    @GetMapping(path="/getOrdersByCustomerId/{id}")
    public List<Order> getOrdersByCustomerById(@PathVariable("id") int id){
        return order_dao.getOrdersByCustomerId(id);
    }

    @GetMapping(path="/getOrderByPaymentType/{type}")
    public List<Order> getOrdersByPaymentType(@PathVariable("type") String type){
        return order_dao.getOrdersByPaymentType(type);
    }

    @GetMapping(path="/getAllOrders")
    public List<Order> getAllOrders(){
        return order_dao.getAllOrders();
    }

    @GetMapping(path="/placeOrder")
    public void placeOrder(){

    }

}
