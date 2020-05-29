package com.shopping.app.api;

import com.shopping.app.dto.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.shopping.app.dao.Customer_Dao;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {

    Customer_Dao customer_dao;

    public CustomerController(@Qualifier("Customer_Dao")Customer_Dao customer_dao){
        this.customer_dao = customer_dao;
    }

    @GetMapping(path="/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customer_dao.getAllCustomers();
    }

    @GetMapping(path="/{id}")
    public Customer getCustomerById(@PathVariable("id") int id){
        return customer_dao.getCustomerById(id);
    }

}
