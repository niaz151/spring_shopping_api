package com.shopping.app.dao;

import com.shopping.app.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository("Category_Dao")
public class Category_Dao_Impl implements Category_Dao{

    @Autowired
    JdbcTemplate template;

    List<Category> category_db = new ArrayList<>();

    /*
    public void addCategory(Category category) {
        int id = category.getId();
        String name = category.getName();
        String description = category.getDescription();
        String query = "INSERT INTO categories VALUES(?,?,?)";
        Object[] params = new Object[] {id, name, description};
        template.update(query, params);
    }
    */

    @Override
    public List<Category> getAllCategories() {
        template.query("SELECT * FROM categories", new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet resultSet, int i) throws SQLException {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                category_db.add(category);
                return category;
            }
        });
        return category_db;
    }

}
