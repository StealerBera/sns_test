package com.example.fastcampusmysql.application.usacase;

import com.example.fastcampusmysql.domain.follow.service.FollowWriteService;
import com.example.fastcampusmysql.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateFollowMemberUsecase {
    final private MemberService memberService;
    final private FollowWriteService followWriteService;

    public void execute(Long fromMemberId, Long toMemberId) {
        var fromMember = memberService.getMember(fromMemberId);
        var toMember = memberService.getMember(toMemberId);

        followWriteService.create(fromMember, toMember);
    }
}
