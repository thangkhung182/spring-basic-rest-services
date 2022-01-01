package com.trungnguyen.api.composite.product;

import com.trungnguyen.api.model.dto.ProductAggregate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface ProductCompositeService {
    @GetMapping("/product-composite/{productId}")
    ProductAggregate getProduct(@PathVariable int productId);
}
