package de.imker.controllers;

import de.imker.controllers.api.MembersApi;
import de.imker.dto.MemberDto;
import de.imker.dto.MembersDto;
import de.imker.dto.NewMemberDto;
import de.imker.dto.UpdateMemberDto;
import de.imker.services.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MembersController implements MembersApi {

  private final MembersService membersService;

  @Override
  public ResponseEntity<MemberDto> addMember(NewMemberDto newMember) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(membersService.addMember(newMember));
  }

  @Override
  public ResponseEntity<MembersDto> getAllMembers() {
    return ResponseEntity
        .ok(membersService.getAllUsers());
  }

  @Override
  public MemberDto getMemberById(Integer memberId) {
    return membersService.getMemberById(memberId);
  }

  @Override
  public MemberDto updateMember(Integer memberId, UpdateMemberDto updateMemberDto) {
    return membersService.updateMember(memberId, updateMemberDto);
  }

  @Override
  public MemberDto deleteMember(Integer memberId) {
    return membersService.deleteMemberById(memberId);
  }
}
