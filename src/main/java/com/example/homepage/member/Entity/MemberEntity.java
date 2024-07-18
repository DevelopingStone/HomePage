package com.example.homepage.member.Entity;

import com.example.homepage.common.entity.BaseEntity;
import com.example.homepage.member.dto.response.AddMemberResponse;
import com.example.homepage.member.dto.response.DeleteMemberResponse;
import com.example.homepage.member.type.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MemberEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private long id;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(nullable = false)
  private String age;

  @Builder
  public MemberEntity(String password, String name, String phoneNumber, Gender gender, String age) {
    this.password = password;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.gender = gender;
    this.age = age;
  }


  public AddMemberResponse toAddMemberResponse() {
    return AddMemberResponse.builder()
        .name(this.name)
        .phoneNumber(this.phoneNumber)
        .gender(this.gender)
        .age(this.age)
        .build();
  }

  public DeleteMemberResponse toDeleteMemberResponse() {
    return DeleteMemberResponse.builder()
        .name(this.name)
        .phoneNumber(this.phoneNumber)
        .gender(this.gender)
        .age(this.age)
        .build();
  }

  public void markAsDeleted() {
    this.setDeletedDttm(LocalDateTime.now());
  }

}
