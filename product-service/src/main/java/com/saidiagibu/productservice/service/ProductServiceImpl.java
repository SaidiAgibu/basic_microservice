package com.saidiagibu.productservice.service;

import com.saidiagibu.productservice.dto.ProductDto;
import com.saidiagibu.productservice.dto.ProductResponse;
import com.saidiagibu.productservice.models.Product;
import com.saidiagibu.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<String> createProduct(ProductDto request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product is created: {}", product);
        return ResponseEntity.ok().body("Product created successfully");

    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products.stream().map(this::mapToProductResponse).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> getSingleProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            return null;
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
