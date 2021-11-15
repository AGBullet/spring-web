package com.homework.spring.web.controllers;

import com.homework.spring.web.model.Product;
import com.homework.spring.web.repo.ProductRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private ProductRepo productRepo;
    public MainController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }




    @GetMapping("/products")
    public String showProductPage(Model model) {
        model.addAttribute("products", productRepo.getAllProducts());
        return "products_page";
    }



    @GetMapping("/products/{id}")
    public String showProductPage(Model model, @PathVariable Long id) {
       Product product = productRepo.findById(id);
        model.addAttribute("product", product);
        return "products_info_page";
    }

}
