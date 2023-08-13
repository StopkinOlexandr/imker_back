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
  private int id;
  private Member.State state;
  @Schema(description = "Members Name", example = "Mart Tven")
  private String name;
  private String position;
  private String description;
  private String image;
  private String email;
  private String facebook;
  private String instagramm;

 public static MemberDto transformMemberToMemberDto(Member member) {
    return MemberDto.builder()
        .id(member.getId())
        .state(member.getState())
        .name(member.getName())
        .position(member.getPosition())
        .description(member.getDescription())
        .image(member.getImage())
        .email(member.getEmail())
        .facebook(member.getFacebook())
        .instagramm(member.getInstagramm())
        .build();
  }

  public static List<MemberDto> transformMemberToMemberDto(List<Member> members) {

//    List<MemberDto> memberDtos = new ArrayList<>();
//
//    for (Member member : members) {
//      memberDtos.add(transformMemberToMemberDto(member));
//    }
//    return memberDtos;

//        return members
//            .stream()
//            .map(member -> transformMemberToMemberDto(member))
//            .collect(Collectors.toList());

            return members
            .stream().map(MemberDto::transformMemberToMemberDto)
            .collect(Collectors.toList());
  }
}
