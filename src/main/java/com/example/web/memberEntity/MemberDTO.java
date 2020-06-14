package com.example.web.memberEntity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MemberDTO {

    private String id,name,password;
}
