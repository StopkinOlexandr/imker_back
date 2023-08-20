package de.imker.services.impl;

import de.imker.dto.NewPostDto;
import de.imker.dto.PostDto;
import de.imker.dto.PostsDto;
import de.imker.exeptions.NotFoundException;
import de.imker.models.Post;
import de.imker.repositories.PostsRepository;
import de.imker.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    PageRequest pageRequest;
    Page<Post> pageOfPosts;

    if (orderBy != null && !orderBy.equals("")) {
      Sort.Direction direction = Sort.Direction.ASC;

      if (desk != null && desk) {
        direction = Sort.Direction.DESC;
      }

      Sort sort = Sort.by(direction, orderBy);
      pageRequest = PageRequest.of(page, items, sort);
    } else {
      pageRequest = PageRequest.of(page, items, Sort.by(Sort.Direction.ASC, "id"));
    }

    pageOfPosts = postsRepository.findAll(pageRequest);

    return PostsDto.builder()
        .posts(PostDto.from(pageOfPosts.getContent()))
        .count((int) pageOfPosts.getTotalElements())
        .pages(pageOfPosts.getTotalPages())
        .build();

//    List<Post> posts = postsRepository.findAllOrderByCreationTimePost();
//    return new PostsDto(PostDto.from(posts),posts.size());
  }

  private Post getPostOrThrow(Long idPost) {
    return postsRepository.getPostById(idPost).orElseThrow(
        () -> new NotFoundException("User with id <" + idPost + "> not found"));
  }
}
