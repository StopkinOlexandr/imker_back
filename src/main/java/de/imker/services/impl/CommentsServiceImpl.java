package de.imker.services.impl;

import de.imker.dto.CommentDto;
import de.imker.dto.CommentsListDto;
import de.imker.dto.NewCommentDto;
import de.imker.models.Comment;
import de.imker.models.User;
import de.imker.repositories.CommentsRepository;
import de.imker.repositories.UsersRepository;
import de.imker.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentsServiceImpl implements CommentsService {
  private final CommentsRepository commentsRepository;
  private final UsersRepository usersRepository;

  @Override
  public CommentDto addComment(NewCommentDto newComment) {
    Comment comment = Comment.builder()
        .commentText(newComment.getCommentText())
        .userId(newComment.getUserId())
        .eventId(newComment.getEventId())
        .postId(newComment.getPostId())
        .build();

    System.out.println(comment);

    commentsRepository.save(comment);

    return CommentDto.builder()
        .id(comment.getId())
        .creationTime(comment.getCreationTimeComment().toString())
        .commentText(comment.getCommentText())
        .userId(comment.getUserId())
        .build();
  }

  @Override
  public CommentsListDto getAllPostComments(Long postId) {
    List<Comment> commentsList = commentsRepository.findAllByPostId(postId);
    List<CommentDto> commentDtoList = getCommentDto(commentsList);
    return CommentsListDto.builder()
        .commentsList(commentDtoList)
        .build();
  }

  @Override
  public CommentsListDto getAllEventComments(Long eventId) {
    List<Comment> commentsList = commentsRepository.findAllByEventId(eventId);
    List<CommentDto> commentDtoList = getCommentDto(commentsList);
    return CommentsListDto.builder()
        .commentsList(commentDtoList)
        .build();
  }

  @Override
  public CommentDto deleteCommentById(Long commentId) {
    Comment comment = commentsRepository.findCommentById(commentId);

    commentsRepository.delete(comment);

    return CommentDto.builder()
        .id(comment.getId())
        .creationTime(comment.getCreationTimeComment().toString())
        .commentText(comment.getCommentText())
        .userId(comment.getUserId())
        .build();
  }

  @NotNull
  private List<CommentDto> getCommentDto(List<Comment> commentsList) {
    List<CommentDto> commentDtoList = new ArrayList<>();

    commentsList.forEach(comment -> {
      Optional<User> user = usersRepository.findById(comment.getUserId());
      user.ifPresent(value -> commentDtoList.add(CommentDto.builder()
          .id(comment.getId())
          .creationTime(comment.getCreationTimeComment().toString())
          .commentText(comment.getCommentText())
          .userId(comment.getUserId())
          .userName(value.getName())
          .userLogo(value.getImage())
          .build()));
    });
    return commentDtoList;
  }
}
