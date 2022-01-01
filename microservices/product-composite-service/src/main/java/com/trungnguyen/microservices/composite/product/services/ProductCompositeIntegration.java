package com.trungnguyen.microservices.composite.product.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trungnguyen.api.core.product.ProductService;
import com.trungnguyen.api.core.recommendation.RecommendationService;
import com.trungnguyen.api.core.review.ReviewService;
import com.trungnguyen.api.model.Product;
import com.trungnguyen.api.model.Recommendation;
import com.trungnguyen.api.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductCompositeIntegration implements ProductService,
        ReviewService, RecommendationService {

    private final RestTemplate restTemplate;

    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    @Autowired
    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("${app.product-service.host}") String productServiceHost,
            @Value("${app.product-service.port}") int productServicePort,
            @Value("${app.recommendation-service.host}") String recommendationServiceHost,
            @Value("${app.recommendation-service.port}") int recommendationServicePort,
            @Value("${app.review-service.host}") String reviewServiceHost,
            @Value("${app.review-service.port}") int reviewServicePort) {

        this.restTemplate = restTemplate;

        productServiceUrl = "http://" + productServiceHost + ":" + productServicePort + "/product/";
        recommendationServiceUrl = "http://" + recommendationServiceHost + ":"
                + recommendationServicePort + "/recommendation?productId=";
        reviewServiceUrl = "http://" + reviewServiceHost + ":" + reviewServicePort + "/review?productId=";
    }

    @Override
    public Product getProduct(int productId) {
        String url = productServiceUrl + productId;
        return restTemplate.getForObject(url, Product.class);
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        String url = recommendationServiceUrl + productId;
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Recommendation>>() {}
        ).getBody();
    }

    @Override
    public List<Review> getReviews(int productId) {
        String url = recommendationServiceUrl + productId;
        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Review>>() {}
        ).getBody();
    }
}
