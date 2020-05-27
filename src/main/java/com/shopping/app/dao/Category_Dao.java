package com.shopping.app.dao;

import com.shopping.app.dto.Category;
import java.util.List;

public interface Category_Dao {

  void addCategory(Category category);

  List<Category> getAllCategories();

}
