package com.example.homepage.member.Repository;

import com.example.homepage.member.Entity.MemberEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

  @Query("SELECT g FROM MemberEntity g WHERE g.deletedDttm IS NULL")
  List<MemberEntity> findAllActive();

}
