package com.trungnguyen.microservices.core.recommendation.services;

import com.trungnguyen.api.core.recommendation.RecommendationService;
import com.trungnguyen.api.exception.InvalidInputException;
import com.trungnguyen.api.model.Recommendation;
import com.trungnguyen.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

  private static final Logger LOG = LoggerFactory.getLogger(RecommendationServiceImpl.class);

  private final ServiceUtil serviceUtil;

  @Override
  public List<Recommendation> getRecommendations(int productId) {

    if (productId < 1) {
      throw new InvalidInputException("Invalid productId: " + productId);
    }

    if (productId == 113) {
      LOG.debug("No recommendations found for productId: {}", productId);
      return new ArrayList<>();
    }

    List<Recommendation> list = new ArrayList<>();
    list.add(new Recommendation(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()));
    list.add(new Recommendation(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()));
    list.add(new Recommendation(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress()));

    LOG.debug("/recommendation response size: {}", list.size());

    return list;
  }
}
