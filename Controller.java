package com.ws101.longcopdayday.controller;

import com.ws101.longcopdayday.model.Product;
import com.ws101.longcopdayday.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products") // Base path mapping [cite: 86, 88]
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK); // [cite: 113]
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // Use @RequestBody to receive JSON data [cite: 102]
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED); // [cite: 113]
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        // Use @PathVariable to extract ID [cite: 103]
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 [cite: 113]
    }
}