package com.homework.spring.web.controllers;

import com.homework.spring.web.model.Product;
import com.homework.spring.web.repo.ProductRepo;
import com.homework.spring.web.servies.PruductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    private ProductRepo repo ;

    public MainController(ProductRepo repo) {
        this.repo = repo;
    }
    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("product", repo.getAllProducts());
        return "product_page";
    }

    @GetMapping("/products/{id}")
    public String showProductPage(Model model, @PathVariable Long id) {
        Product student = repo.findById(id);
        model.addAttribute("product", student);
        return "product_info_page";
    }

}
