package de.imker.controllers.api;

import de.imker.dto.MemberDto;
import de.imker.dto.MembersDto;
import de.imker.dto.NewMemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

  @Operation(summary = "Getting All Members", description = "Avialable for everybody")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "All Members",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation =
                  MembersDto.class))
          })
  })

  @GetMapping
  ResponseEntity<MembersDto> getAllMembers();

  //TODO
  // updateMembers
  // getMemberById

}
