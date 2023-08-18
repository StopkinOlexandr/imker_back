package de.imker.services.impl;

import de.imker.dto.MemberDto;
import de.imker.dto.MembersDto;
import de.imker.dto.NewMemberDto;
import de.imker.dto.UpdateMemberDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Member;
import de.imker.repositories.MembersRepository;
import de.imker.services.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.imker.dto.MemberDto.transformMemberToMemberDto;

@RequiredArgsConstructor
@Service
public class MembersServiceImpl implements MembersService {

  private final MembersRepository memberRepository;

  String newState;

  @Override
  public MemberDto addMember(NewMemberDto newMember) {

    Member member = Member.builder()
        .state(Member.State.SHOW)
        .name(newMember.getName())
        .position(newMember.getPosition())
        .description(newMember.getDescription())
        .image(newMember.getImage())
        .phone(newMember.getPhone())
        .email(newMember.getEmail())
        .facebook(newMember.getFacebook())
        .instagram(newMember.getInstagram())
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

  @Override
  public MemberDto getMemberById(Integer memberId) {
    Member member = memberRepository.getMemberById(memberId);

    return MemberDto.builder()
        .state(member.getState().name())
        .name(member.getName())
        .position(member.getPosition())
        .description(member.getDescription())
        .image(member.getImage())
        .phone(member.getPhone())
        .email(member.getEmail())
        .facebook(member.getFacebook())
        .instagram(member.getInstagram())
        .build();
  }

  @Override
  public MemberDto updateMember(Integer memberId, UpdateMemberDto updateMemberDto) {

    Member updMember = memberRepository.getMemberById(memberId);

    newState = updateMemberDto.getNewState();
    System.out.println("newState  =" + newState);

    updMember.setState(Member.State.valueOf(updateMemberDto.getNewState()));
    updMember.setName(updateMemberDto.getName());
    updMember.setPosition(updateMemberDto.getPosition());
    updMember.setDescription(updateMemberDto.getDescription());
    updMember.setImage(updateMemberDto.getImage());
    updMember.setPhone(updMember.getPhone());
    updMember.setEmail(updateMemberDto.getEmail());
    updMember.setFacebook(updateMemberDto.getFacebook());
    updMember.setInstagram(updateMemberDto.getInstagram());

    memberRepository.save(updMember);

    return transformMemberToMemberDto(updMember);
  }

//  private Member getMemberOrThrow(Integer memberId) {
//    return memberRepository.findById(memberId);
//        .orElseThrow(
//        () -> new NotFoundException("Member not found. Id: ", ""));
//  }
}