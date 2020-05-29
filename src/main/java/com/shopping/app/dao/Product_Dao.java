package com.shopping.app.dao;

import java.util.List;
import com.shopping.app.dto.Product;

public interface Product_Dao {

    Product getProductById(int id);

    List<Product> getProductsByCategoryId(int id);

    List<Product> getAllProducts();

    List<Product> getProductsBySize(int size);

    List<Product> sortProductsByPriceAscending();

    List<Product> sortProductsByPriceDescending();

    List<Product> getProductsByCategoryAndSize(int category, int size);

    List<Product> getProductsByCategoryAndSizeAndPrice(int category, int size, String sort_type);
}
