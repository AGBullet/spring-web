package com.homework.spring.web.repo;

import com.homework.spring.web.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepo {
    private List<Product> products;


    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Milk",10L),
                new Product(2L, "Bread",100L),
                new Product(3L, "Surge",102L),
                new Product(4L, "Bear",103L),
                new Product(5L, "Vino",104L),
                new Product(6L, "Egg",105L)

        ));



    }
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }
    
    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public  void deleteById(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }
}
