package com.homework.spring.web.controllers;

import com.homework.spring.web.model.Product;
import com.homework.spring.web.repo.ProductRepo;
import com.homework.spring.web.servies.PruductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    PruductService pruductService;
    public ProductController(ProductRepo productRepo) {
        this.pruductService = pruductService;
    }


    @GetMapping("/products")
    public List<Product> getAllStudents() {
        return pruductService.getAllStudents();
    }


    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        pruductService.deleteById(id);
    }
}
