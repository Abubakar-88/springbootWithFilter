package com.microtech.controller;

import com.microtech.dto.ProductRequestDTO;
import com.microtech.dto.ProductResponseDTO;
import com.microtech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        // Delegate saving and conversion to the service
        ProductResponseDTO responseDTO = productService.saveProduct(productRequestDTO);

        // Return the response with CREATED status
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public List<ProductResponseDTO> getAllProducts() {
        // Delegate fetching and conversion to the service
        return productService.getAllProducts();
    }
}
