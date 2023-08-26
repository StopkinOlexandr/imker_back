package de.imker.controllers.api;

import de.imker.dto.NewPostDto;
import de.imker.dto.PostDto;
import de.imker.dto.PostsDto;
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
    @Tag(name = "Posts")
})
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173")
public interface PostsApi {

  @Operation(summary = "Create new post", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Post created",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = PostsDto.class))
          })})
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  PostDto addPost(@Parameter(required = true, description = "Post")
                  @RequestBody NewPostDto newPostDto);

  @Operation(summary = "Get post by ID", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Post not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Post data loaded",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = PostDto.class))
          })
  })
  @GetMapping("/{id-post}")
  PostDto getPostById(@Parameter(required = true, description = "Post ID", example = "1")
                      @PathVariable("id-post") Long idPost);

  @Operation(summary = "Post update", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "404", description = "Post not found",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "200", description = "Updated post",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = PostDto.class))
          })
  })
  @PutMapping("/update/{id-post}")
  PostDto updatePost(@Parameter(required = true, description = "Post id", example = "1")
                     @PathVariable("id-post") Long idPost,
                     @RequestBody PostDto postDto);

  @Operation(summary = "Get list of posts", description = "Accessible to all users")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of posts",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = PostsDto.class))
          })})
  @GetMapping
  PostsDto getAllPosts(@Parameter(required = true, description = "Page number", example = "0")
                       @RequestParam(value = "page") Integer page,
                       @Parameter(required = true, description = "Number of items per page", example = "3")
                       @RequestParam(value = "items") Integer items,
                       @Parameter(required = true,
                           description = "Sorting field: id, creationTimePost, titlePost, shortPostDescription, authorName",
                           example = "creationTimePost")
                       @RequestParam(value = "orderBy") String orderBy,
                       @Parameter(required = true,
                           description = "Sorting direction (true = DESK, false = ASK)",
                           example = "true")
                       @RequestParam(value = "desk") Boolean desk);
}
