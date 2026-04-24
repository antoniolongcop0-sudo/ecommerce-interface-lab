package com.ws101.longcop.service;

import com.ws101.longcop.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    // In-memory storage using the Collections Framework [cite: 3, 66]
    private final List<Product> productList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(); // ID Generation [cite: 77]

    public ProductService() {
        // Task 3.1: Initialize with sample data (showing 2 of 10 required) [cite: 67]
        productList.add(new Product(idCounter.incrementAndGet(), "Fila T-Shirt", "Cotton, smooth to wear", 673.0, "Apparel", 50, "pos.jpg"));
        productList.add(new Product(idCounter.incrementAndGet(), "Nike Shoes", "Run smooth and comfortable", 899.0, "Footwear", 20, "nike.jpg"));
    }

    public List<Product> getAllProducts() { 
        return productList; // [cite: 69]
    }

    public Product getProductById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null); // [cite: 70]
    }

    public Product createProduct(Product product) {
        product.setId(idCounter.incrementAndGet());
        productList.add(product);
        return product; // [cite: 71]
    }
}