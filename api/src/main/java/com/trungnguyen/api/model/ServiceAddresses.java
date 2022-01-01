package com.trungnguyen.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAddresses {
  private String cmp;

  private String pro;

  private String rev;

  private String rec;
}