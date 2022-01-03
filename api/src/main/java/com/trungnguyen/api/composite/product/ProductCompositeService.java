package com.trungnguyen.api.composite.product;

import com.trungnguyen.api.model.dto.ProductAggregate;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ProductComposite", description = "REST API for composite product information.")
public interface ProductCompositeService {

    @PostMapping(
            value = "/product-composite",
            consumes = "application/json")
    void createProduct(@RequestBody ProductAggregate body);

    @GetMapping(
            value = "/product-composite/{productId}",
            produces = "application/json")
    ProductAggregate getProduct(@PathVariable int productId);

    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteProduct(@PathVariable int productId);
}
