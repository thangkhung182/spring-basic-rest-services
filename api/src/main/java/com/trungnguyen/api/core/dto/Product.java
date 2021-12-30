package com.trungnguyen.api.core.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Product {
    private int productId;

    private String name;

    private int weight;

    private String serviceAddress;
}
