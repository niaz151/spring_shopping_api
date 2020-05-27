package com.shopping.app.dto;

import java.math.BigDecimal;

public class Product {

    int id;
    int category_id;
    String name;
    String description;
    String img_src;
    BigDecimal price;

    public Product(){}

    public Product(int id, int category_id, String name, String description, String img_src, BigDecimal price) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.description = description;
        this.img_src = img_src;
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
