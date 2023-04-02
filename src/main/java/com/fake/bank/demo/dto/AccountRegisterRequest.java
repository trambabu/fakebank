package com.fake.bank.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountRegisterRequest {

//  private String firstname;
//  private String lastname;
  private String email;
  private String username;
  private String password;
}
