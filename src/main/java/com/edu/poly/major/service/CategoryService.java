package com.edu.poly.major.service;


import com.edu.poly.major.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    public List<Category> getAllCategory();

    public void updateCategory(Category category);

    public void removeCategoryById(int id);

    public Optional<Category> getCategoryById(int id);

}
