package de.imker.services.impl;

import de.imker.dto.MemberDto;
import de.imker.dto.MembersDto;
import de.imker.dto.NewMemberDto;
import de.imker.models.Member;
import de.imker.repositories.MemberRepository;
import de.imker.services.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.imker.dto.MemberDto.transformMemberToMemberDto;

@RequiredArgsConstructor
@Service
public class MembersServiceImpl implements MembersService {

  private final MemberRepository memberRepository;

  @Override
  public MemberDto addMember(NewMemberDto newMember) {

    Member member = Member.builder()
        .state(Member.State.SHOW)
        .name(newMember.getName())
        .position(newMember.getPosition())
        .description(newMember.getDescription())
        .image(newMember.getImage())
        .email(newMember.getEmail())
        .facebook(newMember.getFacebook())
        .instagramm(newMember.getInstagramm())
        .build();


    memberRepository.save(member);

    return transformMemberToMemberDto(member);
  }

  @Override
  public MembersDto getAllUsers() {
    List<Member> members = memberRepository.findAll();

    return MembersDto.builder()
        .members(transformMemberToMemberDto(members))
        .build();
  }



}
