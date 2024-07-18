package com.example.homepage.member.Controller;

import com.example.homepage.member.Service.MemberService;
import com.example.homepage.member.dto.request.AddMemberRequest;
import com.example.homepage.member.dto.response.AddMemberResponse;
import com.example.homepage.member.dto.response.DeleteMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping()
  public ResponseEntity<AddMemberResponse> addMember(@RequestBody AddMemberRequest addMemberRequest) {
    return ResponseEntity.ok(memberService.createMember(addMemberRequest));
  }

  @DeleteMapping("/{member_id}")
  public ResponseEntity<DeleteMemberResponse> removeMember(@PathVariable("member_id") long member_id) {
    return ResponseEntity.ok(memberService.deleteMember(member_id));
  }

}
