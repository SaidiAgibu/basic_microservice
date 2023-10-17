package com.saidiagibu.productservice.service;

import com.saidiagibu.productservice.dto.ProductDto;
import com.saidiagibu.productservice.dto.ProductResponse;
import com.saidiagibu.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public ResponseEntity<String> createProduct(ProductDto request);

    public ResponseEntity<List<ProductResponse>> getAllProducts();

    public ResponseEntity<Product> getSingleProduct(String id);
}
