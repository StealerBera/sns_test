package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.member.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class MemberTest {
    @Test
    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    public void testChangeName(){
        var member = MemberFixtureFactory.create();
        var expected = "pnu";

        member.changeNickname(expected);

        Assertions.assertEquals(expected,member.getNickname());

//        LongStream.range(0,10)
//                .mapToObj(MemberFixtureFactory::create)
//                .forEach(member -> {
//                    System.out.println(member.getNickname());
//                });
    }

    @Test
    @DisplayName("회원의 닉네임은 10자를 초과할 수 없습니다..")
    public void testNickNameMaxLength(){
        var member = MemberFixtureFactory.create();
        var overMaxLengthName = "pnupnupnupnupnu";

        Assertions.assertThrows(IllegalArgumentException.class,()->member.changeNickname(overMaxLengthName));
        member.changeNickname(overMaxLengthName);

        Assertions.assertEquals(overMaxLengthName,member.getNickname());

//        LongStream.range(0,10)
//                .mapToObj(MemberFixtureFactory::create)
//                .forEach(member -> {
//                    System.out.println(member.getNickname());
//                });
    }
}
