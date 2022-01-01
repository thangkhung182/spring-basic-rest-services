package com.trungnguyen.microservices.composite.product.services;

import com.trungnguyen.api.composite.product.ProductCompositeService;
import com.trungnguyen.api.model.Product;
import com.trungnguyen.api.model.Recommendation;
import com.trungnguyen.api.model.Review;
import com.trungnguyen.api.model.ServiceAddresses;
import com.trungnguyen.api.model.dto.ProductAggregate;
import com.trungnguyen.api.model.dto.RecommendationSummary;
import com.trungnguyen.api.model.dto.ReviewSummary;
import com.trungnguyen.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductCompositeServiceImpl implements ProductCompositeService {
    private final ServiceUtil serviceUtil;

    private final ProductCompositeIntegration integration;

    @Override
    public ProductAggregate getProduct(int productId) {
        Product product = integration.getProduct(productId);
        List<Recommendation> recommendations =
                integration.getRecommendations(productId);
        List<Review> reviews = integration.getReviews(productId);
        return createProductAggregate(product, recommendations,
                reviews, serviceUtil.getServiceAddress());
    }

    private ProductAggregate createProductAggregate(
            Product product,
            List<Recommendation> recommendations,
            List<Review> reviews,
            String serviceAddress) {

        // 1. Setup product info
        int productId = product.getProductId();
        String name = product.getName();
        int weight = product.getWeight();

        // 2. Copy summary recommendation info, if available
        List<RecommendationSummary> recommendationSummaries =
                (recommendations == null) ? null : recommendations.stream()
                        .map(r -> new RecommendationSummary(r.getRecommendationId(), r.getAuthor(), r.getRate()))
                        .collect(Collectors.toList());

        // 3. Copy summary review info, if available
        List<ReviewSummary> reviewSummaries =
                (reviews == null) ? null : reviews.stream()
                        .map(r -> new ReviewSummary(r.getReviewId(), r.getAuthor(), r.getSubject()))
                        .collect(Collectors.toList());

        // 4. Create info regarding the involved microservices addresses
        String productAddress = product.getServiceAddress();
        String reviewAddress = (reviews != null && reviews.size() > 0) ? reviews.get(0).getServiceAddress() : "";
        String recommendationAddress = (recommendations != null && recommendations.size() > 0) ? recommendations.get(0).getServiceAddress() : "";
        ServiceAddresses serviceAddresses = new ServiceAddresses(serviceAddress, productAddress, reviewAddress, recommendationAddress);

        return new ProductAggregate(productId, name, weight, recommendationSummaries, reviewSummaries, serviceAddresses);
    }
}
