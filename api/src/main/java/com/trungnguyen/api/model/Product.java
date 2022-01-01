package com.trungnguyen.api.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;

    private String name;

    private int weight;

    private String serviceAddress;
}
