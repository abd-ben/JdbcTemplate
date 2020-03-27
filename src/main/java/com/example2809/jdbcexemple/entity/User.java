package com.example2809.jdbcexemple.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements Serializable {

  private Integer id;
  private String name;
  private String address;
  private String phone;
}
