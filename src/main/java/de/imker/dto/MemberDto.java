package de.imker.dto;

import de.imker.models.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Team Member")
public class MemberDto {

  @Schema(description = "Member's Identification", example = "1")
  private Integer id;
  private String state;
  @Schema(description = "Members Name", example = "Mart Tven")
  private String name;
  private String position;
  private String description;
  private String image;
  private String phone;
  private String email;
  private String facebook;
  private String instagram;

  public static MemberDto transformMemberToMemberDto(Member member) {
    return MemberDto.builder()
        .id(member.getId())
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

  public static List<MemberDto> transformMemberToMemberDto(List<Member> members) {

    return members
        .stream().map(MemberDto::transformMemberToMemberDto)
        .collect(Collectors.toList());
  }
}
