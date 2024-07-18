package com.example.homepage.member.type;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender {

  MALE("남성"),
  FEMALE("여성");

  private final String value;

}
