package de.imker.services;

import de.imker.dto.NewPostDto;
import de.imker.dto.PostDto;
import de.imker.dto.PostsDto;

public interface PostsService {
  PostDto addPost(NewPostDto newPostDto);

  PostDto getPostById(Long idPost);

  PostDto updatePost(Long idPost, PostDto postDto);

  PostsDto getAllPosts(Integer page, Integer items, String orderBy, Boolean desk);
}
