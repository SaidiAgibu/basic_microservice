package com.saidiagibu.inventoryservice.service;

import com.saidiagibu.inventoryservice.dto.InventoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface InventoryService {
    public List<InventoryResponse> isInStock(List<String> skuCode);
}
