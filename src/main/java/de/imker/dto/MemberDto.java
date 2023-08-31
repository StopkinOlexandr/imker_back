package de.imker.dto;

import de.imker.models.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Team Member")
public class MemberDto {

  @Schema(description = "Member's Id", example = "1")
  private Integer id;
  @Schema(description = "Visible members on page AboutUs: SHOW, HIDDEN", example = "SHOW")
  private String state;
  @Schema(description = "Members Name", example = "Mart Tven")
  private String name;
  @Schema(description = "Member's position", example = "")
  private String position;
  @Schema(description = "Description of member", example = "")
  private String description;
  @Schema(description = "Photo", example = "3")
  private String image;
  @Schema(description = "Phone", example = "+49 1234 5678912")
  private String phone;
  @Schema(description = "E-mail", example = "imker@gmail.com")
  @Email
  private String email;
  @Schema(description = "Facebook", example = "https://www.facebook.com/FacebookId")
  private String facebook;
  @Schema(description = "Instagram", example = "https://www.instagram.com/InstagramId")
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
