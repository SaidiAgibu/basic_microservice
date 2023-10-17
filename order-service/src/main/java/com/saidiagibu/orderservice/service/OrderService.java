package com.saidiagibu.orderservice.service;

import com.saidiagibu.orderservice.dto.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public String placeOrder(OrderRequest orderRequest);
}
