package com.example.web.memberEntity;

import com.example.web.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class MemberController {
    @Autowired Member member;
    @Autowired MemberRepository memberRepository;
    @Autowired MemberDTO memberDTO;
    @Autowired MemberMapper memberMapper;

    @PostMapping("/signup")
    public void signup(@RequestBody String total, String id, String name, String password) {
        System.out.println("들어옴");
        System.out.println("total : "+total);
        System.out.println("id : "+id);
        System.out.println("name : "+name);
        System.out.println("password : "+password);
        member.setId(id);
        member.setName(name);
        member.setPassword(password);
        memberRepository.save(member); // hibernate
//        memberDTO.setId(id);
//        memberDTO.setName(name);
//        memberDTO.setPassword(password);
//        memberMapper.insertMember(memberDTO); // mybatis


    }
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody String total, String id, String password) {
//        System.out.println("");
//        System.out.println("들어옴");
//        System.out.println("total :" +total);
//        System.out.println("id : "+id);
//        System.out.println("password : "+password);
        Map<String,Object> map = new HashMap<>();
        try {
//            System.out.println("id값 : "+memberRepository.findById(id).getId());
//            System.out.println("passwd값 : "+memberRepository.findByPassword(password).getPassword());
            if(memberRepository.findById(id).getId() != null &&
                    memberRepository.findByPassword(password).getPassword() != null){
                System.out.println("로그인 성공");
                map.put("result", true);
                member = memberRepository.findById(id);
                System.out.println(member.toString());
                map.put("member",member);
            }
        }catch(Exception e){
            System.out.println("로그인 실패");
            map.put("result", false);
        }

        return map;
    }
}
