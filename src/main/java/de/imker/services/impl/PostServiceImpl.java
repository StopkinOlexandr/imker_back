package de.imker.services.impl;

import de.imker.dto.NewPostDto;
import de.imker.dto.PostDto;
import de.imker.dto.PostsDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Post;
import de.imker.repositories.PostsRepository;
import de.imker.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostsService {
  private final PostsRepository postsRepository;

  @Override
  public PostDto addPost(NewPostDto newPostDto) {
    Post post = Post.builder()
        .titlePost(newPostDto.getTitlePost())
        .linkToImg(newPostDto.getLinkToImg())
        .shortPostDescription(newPostDto.getShortPostDescription())
        .textOfPost(newPostDto.getTextOfPost())
        .idUser(newPostDto.getIdUser())
        .build();

    postsRepository.save(post);

    return PostDto.from(post);
  }

  @Override
  public PostDto getPostById(Long idPost) {
    Post post = getPostOrThrow(idPost);

    return PostDto.builder()
        .idPost(post.getIdPost())
        .creationTimePost(post.getCreationTimePost().toString())
        .titlePost(post.getTitlePost())
        .linkToImg(post.getLinkToImg())
        .shortPostDescription(post.getShortPostDescription())
        .textOfPost(post.getTextOfPost())
        .idUser(post.getIdUser())
        .build();
  }

  @Override
  public PostDto updatePost(Long idPost, PostDto postDto) {
    Post post = getPostOrThrow(idPost);

    post.setTitlePost(postDto.getTitlePost());
    post.setLinkToImg(postDto.getLinkToImg());
    post.setShortPostDescription(postDto.getShortPostDescription());
    post.setTextOfPost(postDto.getTextOfPost());
    post.setIdUser(postDto.getIdUser());

    postsRepository.save(post);

    return PostDto.from(post);
  }

  @Override
  public PostsDto getAllPosts() {
    List<Post> posts = postsRepository.findAllOrderByCreationTimePost();
    return new PostsDto(PostDto.from(posts),posts.size());
  }

  private Post getPostOrThrow(Long idPost) {
    return postsRepository.getPostByIdPost(idPost).orElseThrow(
        () -> new NotFoundException("User with id <" + idPost + "> not found"));
  }
}
