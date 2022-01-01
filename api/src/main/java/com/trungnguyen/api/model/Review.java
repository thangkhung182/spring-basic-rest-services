package com.trungnguyen.api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
  private int productId;

  private int reviewId;

  private String author;

  private String subject;

  private String content;

  private String serviceAddress;
}
