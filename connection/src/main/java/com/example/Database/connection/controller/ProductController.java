package com.example.Database.connection.controller;

import com.example.Database.connection.model.entity.Product;
import com.example.Database.connection.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //POST /products -> ruajtja e nje produkti
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    //GET /products -> merr te gjithe produktet
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }
}
