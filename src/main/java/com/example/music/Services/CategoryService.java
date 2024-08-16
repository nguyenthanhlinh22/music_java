package com.example.music.Services;

import com.example.music.Models.CategoryModel;
import com.example.music.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private CategoryModel categoryModel;


    public CategoryService(){
        this.categoryModel = new CategoryModel();
    }

    public List<Category> getAllcategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        ResultSet resultSet = this.categoryModel.getAllCategory();
        //xu ly kq tra ve
        while (resultSet.next()) {
            int categoryid = resultSet.getInt("categoryid");
            String categoryname = resultSet.getString("categoryname");
            Category category = new Category(categoryname);
            category.setCategoryid(categoryid);
            categories.add(category);
        }
        return categories;
    }
}
