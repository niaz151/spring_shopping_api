package com.shopping.app.dao;

import com.shopping.app.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("Customer_Dao")
public class Customer_Dao_Impl implements Customer_Dao{

    @Autowired
    JdbcTemplate template;

    List<Customer> customer_db = new ArrayList<>();

    @Override
    public Customer getCustomerById(int id) {
        final Customer[] output_arr = new Customer[1];
        template.query("SELECT * FROM customers WHERE id=" + id , new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFname(resultSet.getString("first_name"));
                customer.setLname(resultSet.getString("last_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPostal_code(resultSet.getInt("postal_code"));
                customer.setPhone_number(resultSet.getInt("phone"));
                customer.setEmail(resultSet.getString("email"));
                output_arr[0] = customer;
                return customer;
            }
        });
        return output_arr[0];
    }

    @Override
    public List<Customer> getAllCustomers() {
        template.query("SELECT * FROM customers", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFname(resultSet.getString("first_name"));
                customer.setLname(resultSet.getString("last_name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPostal_code(resultSet.getInt("postal_code"));
                customer.setPhone_number(resultSet.getInt("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer_db.add(customer);
                return customer;
            }
        });
        return customer_db;
    }
}
