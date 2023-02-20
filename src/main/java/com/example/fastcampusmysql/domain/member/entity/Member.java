package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Getter
@Setter
public class Member {
    final private Long id;
    private String nickname;
    final private String email;
    final private LocalDate birthday;

    final private LocalDateTime createdAt;

    final private static Long NAME_MAX_LENGTH = 10L;
    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthday, LocalDateTime createdAt) {
        this.id = id;
        this.nickname = Objects.requireNonNull(nickname);
        validateNickName(nickname);

        this.email =    Objects.requireNonNull(email);
        this.birthday = Objects.requireNonNull(birthday);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    public void changeNickname(String other){
        Objects.requireNonNull(other);
        validateNickName(other);
        nickname = other;
    }

    void validateNickName(String nickname){
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH,"최대 길이를 초과했습니다.") ;
    }
}
