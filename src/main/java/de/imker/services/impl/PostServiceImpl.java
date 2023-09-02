package de.imker.services.impl;

import de.imker.dto.NewPostDto;
import de.imker.dto.PostDto;
import de.imker.dto.PostsDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Post;
import de.imker.repositories.PostsRepository;
import de.imker.services.FilesService;
import de.imker.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static de.imker.utils.UtilsMethods.getPageRequest;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostsService {
  private final PostsRepository postsRepository;
  private final FilesService filesService;

  @Override
  public PostDto addPost(NewPostDto newPostDto) {
    Post post = Post.builder()
        .titlePost(newPostDto.getTitlePost())
        .linkToImg(newPostDto.getLinkToImg())
        .shortPostDescription(newPostDto.getShortPostDescription())
        .textOfPost(newPostDto.getTextOfPost())
        .authorName(newPostDto.getAuthorName())
        .build();

    postsRepository.save(post);

    return PostDto.from(post);
  }

  @Override
  public PostDto getPostById(Long idPost) {
    Post post = getPostOrThrow(idPost);

    return PostDto.builder()
        .idPost(post.getId())
        .creationTimePost(post.getCreationTimePost().toString())
        .titlePost(post.getTitlePost())
        .linkToImg(post.getLinkToImg())
        .shortPostDescription(post.getShortPostDescription())
        .textOfPost(post.getTextOfPost())
        .authorName(post.getAuthorName())
        .build();
  }

  @Override
  public PostDto updatePost(Long idPost, PostDto postDto) {
    Post post = getPostOrThrow(idPost);

    if (!Objects.equals(post.getLinkToImg(), postDto.getLinkToImg())) {
      filesService.deleteFileById(Long.valueOf(post.getLinkToImg()));
    }

    post.setTitlePost(postDto.getTitlePost());
    post.setLinkToImg(postDto.getLinkToImg());
    post.setShortPostDescription(postDto.getShortPostDescription());
    post.setTextOfPost(postDto.getTextOfPost());
    post.setAuthorName(postDto.getAuthorName());

    postsRepository.save(post);

    return PostDto.from(post);
  }

  @Override
  public PostsDto getAllPosts(Integer page, Integer items, String orderBy, Boolean desk) {

    Page<Post> pageOfPosts;

    PageRequest pageRequest = getPageRequest(page, items, orderBy, desk);

    pageOfPosts = postsRepository.findAll(pageRequest);

    return PostsDto.builder()
        .posts(PostDto.from(pageOfPosts.getContent()))
        .count((int) pageOfPosts.getTotalElements())
        .pages(pageOfPosts.getTotalPages())
        .build();
  }

  private Post getPostOrThrow(Long idPost) {
    return postsRepository.getPostById(idPost).orElseThrow(
        () -> new NotFoundException("User with id <" + idPost + "> not found"));
  }
}
