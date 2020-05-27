package com.shopping.app.api;

import com.shopping.app.dao.Product_Dao;
import com.shopping.app.dto.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    Product_Dao product_dao;

    public ProductController(@Qualifier("Product_Dao") Product_Dao product_dao){
        this.product_dao = product_dao;
    }

    @GetMapping(path="/getProductById/{id}")
    public Product getProductById(@PathVariable("id") int id){
        return product_dao.getProductById(id);
    }

    @GetMapping(path="/getProductsByCategoryId/{id}")
    public List<Product> getProductsByCategoryId(@PathVariable("id") int id){
        return product_dao.getProductsByCategoryId(id);
    }

    @GetMapping(path="/getAllProducts")
    public List<Product> getAllProducts(){
        return product_dao.getAllProducts();
    }
}
