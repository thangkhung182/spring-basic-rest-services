package com.trungnguyen.microservices.core.product.services;

import com.trungnguyen.api.model.Product;
import com.trungnguyen.api.core.product.ProductService;
import com.trungnguyen.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ServiceUtil serviceUtil;

    @Override
    public Product getProduct(int productId) {
        return Product.builder()
                .productId(productId)
                .name("product-" +productId)
                .serviceAddress(serviceUtil.getServiceAddress())
                .build();
    }
}
