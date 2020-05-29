package com.shopping.app.dao;

import com.shopping.app.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("Product_Dao")
public class Product_Dao_Impl implements Product_Dao {

    @Autowired
    JdbcTemplate template;

    @Override
    public Product getProductById(int id) {
        List<Product> output_arr = new ArrayList<>();
        template.query("SELECT * FROM products WHERE id=" + id , new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr.get(0);
    }

    @Override
    public List<Product> getProductsByCategoryId(int id) {

        String query = (id == 0)? "SELECT * FROM products": "SELECT * FROM products WHERE category_id=" + id;

        List<Product> output_arr = new ArrayList<>();
        template.query(query , new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr;
    }

    @Override
    public List<Product> getProductsBySize(int size) {

        String query = (size == 0)? "SELECT * FROM products ": "SELECT * FROM products WHERE size=" + size;

        List<Product> output_arr = new ArrayList<>();
        template.query(query, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr;
    }

    @Override
    public List<Product> sortProductsByPriceAscending() {
        List<Product> output_arr = new ArrayList<>();
        template.query("SELECT * FROM products ORDER BY price ASC" , new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr;
    }

    @Override
    public List<Product> sortProductsByPriceDescending() {
        List<Product> output_arr = new ArrayList<>();
        template.query("SELECT * FROM products ORDER BY price DESC" , new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> output_arr = new ArrayList<>();
        template.query("SELECT * FROM products", new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr;
    }

    @Override
    public List<Product> getProductsByCategoryAndSize(int category, int size) {

        // IF ALL PRODUCTS NEEDS TO BE FILTERED
        if(category == 0){ return getProductsBySize(size); }

        // IF NO SIZE FILTER
        if(size == 0){ return getProductsByCategoryId(category); }

        List<Product> output_arr = new ArrayList<>();
        template.query("SELECT * FROM products WHERE category_id=" + category + " AND size="+ size, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr;
    }

    @Override
    public List<Product> getProductsByCategoryAndSizeAndPrice(int category, int size, String sort_type) {

        String query = "SELECT * FROM products WHERE category_id=" + category + " AND size="+ size + " ORDER BY price " + sort_type;

        // IF NO CATEGORY OR SIZE FILTER AND THERE IS A SORT FILTER
        if(category == 0 && size == 0 && !sort_type.equals("None")) {
            query = "SELECT * FROM products ORDER BY price " + sort_type;
        }

        // IF NO CATEGORY OR SIZE FILTER AND THERE IS NO SORT FILTER
        if(category == 0 && size == 0 && sort_type.equals("None")) {
            query = "SELECT * FROM products";
        }

        //IF ONLY CATEGORY FILTER AND SORT FILTER
        if(category != 0 && size == 0 && !sort_type.equals("None")){
            query = "SELECT * FROM products WHERE category_id=" + category + " ORDER BY price " + sort_type;
        }

        //IF ONLY CATEGORY FILTER AND NO SORT FILTER
        if(category != 0 && size == 0 && !sort_type.equals("None")){
            query = "SELECT * FROM products WHERE category_id=" + category;
        }

        // IF ONLY SIZE FILTER AND SORT FILTER
        if(category == 0 && size != 0 && !sort_type.equals("None")){
            query = "SELECT * FROM products WHERE size=" + size + " ORDER BY price " + sort_type;
        }

        // IF ONLY SIZE FILTER AND NO SORT FILTER
        if(category == 0 && size != 0 && sort_type.equals("None")){
            query = "SELECT * FROM products WHERE size=" + size;
        }
        
        List<Product> output_arr = new ArrayList<>();
        template.query(query,  new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory_id(resultSet.getInt("category_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setImg_src(resultSet.getString("image"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setSize(resultSet.getInt("size"));
                output_arr.add(product);
                return product;
            }
        });
        return output_arr;
    }


}
