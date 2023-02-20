package com.example.fastcampusmysql.controller;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.dto.MemberNicknameHistoryDto;
import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    final private MemberService memberService;

    @PostMapping("")
    public MemberDto register(@RequestBody RegisterMemberCommand command){
        var member = memberService.register(command);
        return memberService.toDto(member);
    }

    @GetMapping("/{id}")
    public MemberDto getMember(@PathVariable Long id){
        return memberService.getMember(id);
    }

    @PostMapping("/{id}/name")
    public MemberDto changeNickname(@PathVariable Long id, @RequestBody String nickname){
        memberService.changeNickName(id,nickname);
        return memberService.getMember(id);
    }

    @GetMapping("/{id}/name-histories")
    public List<MemberNicknameHistoryDto> getMemberNameHistories(@PathVariable Long id) {
        return memberService.getNicknameHistories(id);
    }
}
