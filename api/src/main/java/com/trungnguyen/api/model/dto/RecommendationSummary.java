package com.trungnguyen.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationSummary {
  private int recommendationId;

  private String author;

  private int rate;
}
