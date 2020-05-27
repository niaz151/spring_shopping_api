package com.shopping.app.api;

import com.shopping.app.dto.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.shopping.app.dao.*;

import java.util.List;

@RequestMapping("/api/v1/categories/getAllCategories")
@RestController
public class CategoryController {

    Category_Dao category_dao;

    public CategoryController(@Qualifier("Category_Dao")Category_Dao category_dao){
        this.category_dao = category_dao;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return category_dao.getAllCategories();
    }

}
