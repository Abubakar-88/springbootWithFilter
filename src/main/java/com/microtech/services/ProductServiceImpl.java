package com.microtech.services;


import com.microtech.dto.ProductRequestDTO;
import com.microtech.dto.ProductResponseDTO;
import com.microtech.entity.Product;
import com.microtech.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        // Convert ProductRequestDTO to Product entity
        Product product = modelMapper.map(productRequestDTO, Product.class);

        // Save product to database
        Product savedProduct = productRepository.save(product);

        // Convert saved Product entity to ProductResponseDTO
        return modelMapper.map(savedProduct, ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        // Fetch all products
        List<Product> products = productRepository.findAll();

        // Convert List<Product> to List<ProductResponseDTO>
        return products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }
}
