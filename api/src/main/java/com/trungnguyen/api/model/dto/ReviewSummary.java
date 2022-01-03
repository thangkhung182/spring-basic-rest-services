package com.trungnguyen.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewSummary {
  private int reviewId;

  private String author;

  private String subject;

  private String content;
}
