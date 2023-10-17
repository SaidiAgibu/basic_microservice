package com.saidiagibu.productservice.controller;

import com.saidiagibu.productservice.dto.ProductDto;
import com.saidiagibu.productservice.dto.ProductResponse;
import com.saidiagibu.productservice.models.Product;
import com.saidiagibu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductDto request) {
        return productService.createProduct(request);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Product> getSingleProduct(@PathVariable("id") String id) {
        return productService.getSingleProduct(id);
    }
}
