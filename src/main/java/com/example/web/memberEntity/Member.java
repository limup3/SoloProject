package com.example.web.memberEntity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="Member")
@Component
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long No;

    private String id, name, password;

    @Builder
    public Member(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
