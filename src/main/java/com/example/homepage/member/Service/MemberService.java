package com.example.homepage.member.Service;

import com.example.homepage.member.Entity.MemberEntity;
import com.example.homepage.member.Repository.MemberRepository;
import com.example.homepage.member.dto.request.AddMemberRequest;
import com.example.homepage.member.dto.response.AddMemberResponse;
import com.example.homepage.member.dto.response.DeleteMemberResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

  private final MemberRepository memberRepository;

  @Transactional
  public AddMemberResponse createMember(AddMemberRequest addMemberRequest) {
    MemberEntity entity = addMemberRequest.toEntity();
    return memberRepository.save(entity).toAddMemberResponse();
  }

  @Transactional
  public DeleteMemberResponse deleteMember(long deleteMemberRequest) {
    MemberEntity memberById = findMemberById(deleteMemberRequest);
    memberById.markAsDeleted();
    return memberRepository.save(memberById).toDeleteMemberResponse();
  }

  private MemberEntity findMemberById(long id) {
    return memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Member not found with id " + id));
  }

}
