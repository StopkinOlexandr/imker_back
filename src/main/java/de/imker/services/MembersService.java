package de.imker.services;

import de.imker.dto.MemberDto;
import de.imker.dto.MembersDto;
import de.imker.dto.NewMemberDto;

public interface MembersService {

  MemberDto addMember(NewMemberDto newMember);

  MembersDto getAllUsers();

  //TODO
  // updateMembers
  // getMemberById
}
