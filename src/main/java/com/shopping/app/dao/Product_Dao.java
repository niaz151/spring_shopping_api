package com.shopping.app.dao;

import java.util.List;
import com.shopping.app.dto.Product;

public interface Product_Dao {

    Product getProductById(int id);

    List<Product> getProductsByCategoryId(int id);

    List<Product> getAllProducts();
}
