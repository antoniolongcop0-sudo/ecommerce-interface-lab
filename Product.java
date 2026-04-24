package com.ws101.longcopdayday.model;

import lombok.*;

/**
 * Data entity representing an e-commerce product.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id; // Unique identifier [cite: 40]
    private String name; // Product name [cite: 41]
    private String description; // Product description [cite: 42]
    private double price; // Product price [cite: 43]
    private String category; // Product category [cite: 44]
    private int stockQuantity; // Stock level [cite: 45]
    private String imageUrl; // Optional image path [cite: 46]
}