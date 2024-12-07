package com.microtech.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;
    private String category;
    private double price;
    private boolean inStock;
}
