package com.ddddrecipe.member;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "MEMBER")
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String nickname;

    private String email;

    private String password;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String nickname, String email, String password, boolean enabled, Role role) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }
}
