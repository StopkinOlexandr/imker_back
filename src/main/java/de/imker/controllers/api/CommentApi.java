package de.imker.controllers.api;

import de.imker.dto.CommentDto;
import de.imker.dto.CommentsListDto;
import de.imker.dto.NewCommentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tags(value = {
    @Tag(name = "Comment")
})
@RequestMapping("/api/comment")
@CrossOrigin(origins = "http://localhost:5173")
public interface CommentApi {

  @Operation(summary = "Add comment", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Comment stored",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDto.class))
          })})
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  CommentDto addComment(@Parameter(required = true, description = "NewCommentDto")
                        @RequestBody NewCommentDto newComment);

  @Operation(summary = "Get list of comments for post", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of comments",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = CommentsListDto.class))
          })})
  @GetMapping(path = "/post")
  CommentsListDto getAllPostComments(@Parameter(required = true, description = "Post id", example = "1")
                                     @RequestParam(value = "id") Long postId);

  @Operation(summary = "Get list of comments for event", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of comments",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = CommentsListDto.class))
          })})
  @GetMapping(path = "/event")
  CommentsListDto getAllEventComments(@Parameter(required = true, description = "Event id", example = "1")
                                      @RequestParam(value = "id") Long eventId);

  @Operation(summary = "Delete comment by ID", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Comment deleted",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDto.class))
          })
  })
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(path = "/delete/{comment-id}")
  CommentDto deleteCommentById(@Parameter(required = true, description = "Comment ID", example = "1")
                               @PathVariable("comment-id") Long commentId);
}
