package com.example.Database.connection.controller;

import com.example.Database.connection.model.entity.Category;
import com.example.Database.connection.model.entity.Product;
import com.example.Database.connection.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return  categoryService.save(category);
    }

    //get /categories/{id}
    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategory(@PathVariable Long id){
        return  categoryService.getProductsByCategoryId(id);
    }
}
