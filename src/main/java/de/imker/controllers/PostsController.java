package de.imker.controllers;

import de.imker.controllers.api.PostsApi;
import de.imker.dto.NewPostDto;
import de.imker.dto.PostDto;
import de.imker.dto.PostsDto;
import de.imker.services.PostsService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsController implements PostsApi {
  private final PostsService postsService;

  @Override
  public PostDto addPost(@Parameter(required = true, description = "Post")
                         @RequestBody NewPostDto newPostDto) {

    return postsService.addPost(newPostDto);
  }

  @Override
  public PostDto getPostById(Long idPost) {
    return postsService.getPostById(idPost);
  }

  @Override
  public PostDto updatePost(Long idPost, PostDto postDto) {
    System.out.println(idPost);
    System.out.println(postDto);
    return postsService.updatePost(idPost ,postDto);
  }

  @Override
  public PostsDto getAllPosts() {
    return postsService.getAllPosts();
  }

}
