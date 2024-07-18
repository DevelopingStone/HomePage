package com.example.homepage.member.dto.response;

import com.example.homepage.member.type.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddMemberResponse {

  @NotBlank
  private String name;

  @NotBlank
  private String phoneNumber;

  @NotBlank
  private Gender gender;

  @NotBlank
  private String age;

  @Builder
  public AddMemberResponse(String name, String phoneNumber, Gender gender, String age) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.gender = gender;
    this.age = age;
  }
}
