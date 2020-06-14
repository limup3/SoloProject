package com.example.web.mapper;

import com.example.web.memberEntity.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    public void insertMember(MemberDTO member);
}
