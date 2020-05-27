package com.shopping.app.api;

import com.shopping.app.dto.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.shopping.app.dao.*;

import java.util.List;

@RequestMapping("/api/v1/getAllCategories")
@RestController
public class Controller {

    Category_Dao category_dao;

    public Controller(@Qualifier("Category_Dao")Category_Dao category_dao){
        this.category_dao = category_dao;
    }

    @PostMapping
    public void addCategory(@RequestBody Category category){
        category_dao.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return category_dao.getAllCategories();
    }

}
