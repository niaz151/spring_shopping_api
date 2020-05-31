package com.shopping.app.dao;

import com.shopping.app.dto.Customer;
import com.shopping.app.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("Order_Dao")
public class Order_Dao_Impl implements Order_Dao{

    @Autowired
    JdbcTemplate template;

    List<Order> order_db = new ArrayList<>();

    @Override
    public Order getOrderById(int id) {
        List<Order> output_arr = new ArrayList<>();
        template.query("SELECT * FROM orders WHERE id=" + id , new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCustomer_id(resultSet.getInt("customer_id"));
                order.setPayment_type(resultSet.getString("payment_type"));
                order.setDate_time(resultSet.getDate("date"));
                order.setStatus(resultSet.getString("status"));
                order.setTotal(resultSet.getBigDecimal("total"));
                output_arr.add(order);
                return order;
            }
        });
        return output_arr.get(0);
    }

    @Override
    public List<Order> getOrdersByCustomerId(int id) {
        List<Order> orders = new ArrayList<>();
        template.query("SELECT * FROM orders WHERE customer_id=" + id , new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCustomer_id(resultSet.getInt("customer_id"));
                order.setPayment_type(resultSet.getString("payment_type"));
                order.setDate_time(resultSet.getDate("date"));
                order.setStatus(resultSet.getString("status"));
                order.setTotal(resultSet.getBigDecimal("total"));
                orders.add(order);
                return order;
            }
        });
        return orders;
    }

    @Override
    public List<Order> getOrdersByPaymentType(String payment_type) {
        List<Order> orders = new ArrayList<>();
        template.query("SELECT * FROM orders WHERE payment_type=" + payment_type , new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCustomer_id(resultSet.getInt("customer_id"));
                order.setPayment_type(resultSet.getString("payment_type"));
                order.setDate_time(resultSet.getDate("date"));
                order.setStatus(resultSet.getString("status"));
                order.setTotal(resultSet.getBigDecimal("total"));
                orders.add(order);
                return order;
            }
        });
        return orders;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        template.query("SELECT * FROM orders ", new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCustomer_id(resultSet.getInt("customer_id"));
                order.setPayment_type(resultSet.getString("payment_type"));
                order.setDate_time(resultSet.getDate("date"));
                order.setStatus(resultSet.getString("status"));
                order.setTotal(resultSet.getBigDecimal("total"));
                orders.add(order);
                return order;
            }
        });
        return orders;
    }

    @Override
    public void placeOrder(Order order) {
        order_db.add(order);
    }

}
