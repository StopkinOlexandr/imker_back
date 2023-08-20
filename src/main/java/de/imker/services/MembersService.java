package de.imker.services;

import de.imker.dto.MemberDto;
import de.imker.dto.MembersDto;
import de.imker.dto.NewMemberDto;
import de.imker.dto.UpdateMemberDto;

public interface MembersService {

  MemberDto addMember(NewMemberDto newMember);

  MembersDto getAllUsers();

  MemberDto getMemberById(Integer memberId);

  MemberDto updateMember(Integer memberId, UpdateMemberDto updateMemberDto);

  MemberDto deleteMemberById(Integer memberId);

}
