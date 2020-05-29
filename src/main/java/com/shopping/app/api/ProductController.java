package com.shopping.app.api;

import com.shopping.app.dao.Product_Dao;
import com.shopping.app.dto.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    Product_Dao product_dao;

    public ProductController(@Qualifier("Product_Dao") Product_Dao product_dao){
        this.product_dao = product_dao;
    }

    @GetMapping(path="/getAllProducts")
    public List<Product> getAllProducts(){
        return product_dao.getAllProducts();
    }

    @GetMapping(path="/getProduct/id={id}")
    public Product getProductById(@PathVariable("id") int id){
        return product_dao.getProductById(id);
    }


    @GetMapping(path="/getProducts/category={id}")
    public List<Product> getProductsByCategoryId(@PathVariable("id") int id){
        return product_dao.getProductsByCategoryId(id);
    }

    @GetMapping(path="/getProducts/size={size}")
    public List<Product> getAllProducts(@PathVariable("size") int size){
        return product_dao.getProductsBySize(size);
    }

    @GetMapping(path="/getProducts/price=ascending")
    public List<Product> getProductsByPriceAsc(){
        return product_dao.sortProductsByPriceAscending();
    }

    @GetMapping(path="/getProducts/price=descending")
    public List<Product> getProductsByPriceDesc(){
        return product_dao.sortProductsByPriceDescending();
    }

    @GetMapping(path="/getProducts/category={category_id}/size={size}")
    public List<Product> getProductsByCategoryAndSize(@PathVariable("category_id") int cat_id,
                                                @PathVariable("size") int size){
        return product_dao.getProductsByCategoryAndSize(cat_id, size);
    }

    @GetMapping(path="/getProducts/category={category_id}/size={size}/sort={sort_type}")
    public List<Product> getProductsByCategoryAndSizeAndPrice(@PathVariable("category_id") int cat_id,
                                                @PathVariable("size") int size,
                                                @PathVariable("sort_type") String sort_type){
        return product_dao.getProductsByCategoryAndSizeAndPrice(cat_id, size, sort_type);
    }
}
