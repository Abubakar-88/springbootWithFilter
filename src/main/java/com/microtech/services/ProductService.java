package com.microtech.services;

import com.microtech.dto.ProductRequestDTO;
import com.microtech.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getAllProducts();

}
