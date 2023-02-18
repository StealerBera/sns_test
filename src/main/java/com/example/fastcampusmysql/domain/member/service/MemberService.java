package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repositiry.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MemberService {
    final private MemberRepository memberRepository;
    public Member register(RegisterMemberCommand command) {
        /*
         * 목표 - 회원정보(이메일, 닉네임, 생년월일) 을 등록한다.
         *     - 닉네임은 18자를 넘길 수 없다
         * 파라미터 - memberRegisterCommand
         * vol member = Member.of(memberRegisterCommand)
         * memberRepository.save(member)
         * */

        var member = Member.builder()
                .nickname(command.nickName())
                .email(command.email())
                .birthday(command.birthdate())
                .build();

        memberRepository.save(member);

        return member;

    }

    public MemberDto getMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow();
        return toDto(member);
    }

    public MemberDto toDto(Member member){
        return new MemberDto(member.getId(),member.getEmail(),member.getNickname());
    }
}
