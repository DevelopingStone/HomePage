package com.example.homepage.member.dto.request;

import com.example.homepage.member.Entity.MemberEntity;
import com.example.homepage.member.type.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddMemberRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String password;

  @NotBlank
  private String phoneNumber;

  @NotBlank
  private Gender gender;

  @NotBlank
  private String age;

  public MemberEntity toEntity() {
    return MemberEntity.builder()
        .name(this.name)
        .password(this.password)
        .phoneNumber(this.phoneNumber)
        .gender(this.gender)
        .age(this.age)
        .build();
  }

}
