package com.example.Database.connection.service;

import com.example.Database.connection.model.entity.Category;
import com.example.Database.connection.model.entity.Product;
import com.example.Database.connection.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public List<Product> getProductsByCategoryId(Long categoryId){
        return  categoryRepository.findById(categoryId)
                .map(Category::getProducts)
                .orElseThrow(() -> new RuntimeException("Kategoria nuk u gjet")
        );
    }
}
