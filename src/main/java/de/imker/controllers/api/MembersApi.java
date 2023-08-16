package de.imker.controllers.api;

import de.imker.dto.MemberDto;
import de.imker.dto.MembersDto;
import de.imker.dto.NewMemberDto;
import de.imker.dto.UpdateMemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/members")
@Tags(value = {
    @Tag(name = "Members")
})

public interface MembersApi {

  @Operation(summary = "Create Member", description = "Avialable Only For Admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Add Member",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  MemberDto.class))
          })
  })

  @PostMapping
  ResponseEntity<MemberDto> addMember(@RequestBody NewMemberDto newMember);


  @Operation(summary = "Getting All Members", description = "Avialable Only For Admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "All Members",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  MembersDto.class))
          })
  })

  @GetMapping
  ResponseEntity<MembersDto> getAllMembers();


  @Operation(summary = "Get Member by Id", description = "Avialable Only For Admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get Member by Id",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  MembersDto.class))
          }),
      @ApiResponse(responseCode = "404", description = "Member by Id Not Found",
          content = {
              @Content()
          })
  })

  @GetMapping("/{member-id}")
  MemberDto getMemberById(
      @Parameter(required = true, description = "Get Member by Id",
          example = "1")
      @PathVariable("member-id") Integer memberId);


  @Operation(summary = "Update Member by Id", description = "Avialable Only For Admin")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Member Updated",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  MembersDto.class))
          })
  })

  @PutMapping("/update/{memberId}")
  MemberDto updateMember(
      @Parameter(required = true, description = "ID Membr's To Update",
          example = "1")
      @PathVariable("memberId") Integer memberId,
      @RequestBody UpdateMemberDto updateMemberDto);

  // TODO
  //  getMemberByState

}
