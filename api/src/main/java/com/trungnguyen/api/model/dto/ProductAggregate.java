package com.trungnguyen.api.model.dto;

import com.trungnguyen.api.model.ServiceAddresses;
import com.trungnguyen.api.model.dto.RecommendationSummary;
import com.trungnguyen.api.model.dto.ReviewSummary;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductAggregate {
    private int productId;

    private String name;

    private int weight;

    private List<RecommendationSummary> recommendations;

    private List<ReviewSummary> reviews;

    private ServiceAddresses serviceAddresses;
}
