package com.homework.spring.web.servies;

import com.homework.spring.web.model.Product;
import com.homework.spring.web.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PruductService {
    private ProductRepo repo;

    public PruductService(ProductRepo repo) {
        this.repo =repo ;
    }

    public List<Product> getAllStudents() {
        return repo.getAllProducts();
    }


    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
