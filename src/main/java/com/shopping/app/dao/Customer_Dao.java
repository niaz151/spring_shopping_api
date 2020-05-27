package com.shopping.app.dao;

import java.util.List;

import com.shopping.app.dto.Customer;

public interface Customer_Dao {

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

}
