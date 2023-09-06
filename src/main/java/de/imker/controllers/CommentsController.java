package de.imker.controllers;

import de.imker.controllers.api.CommentApi;
import de.imker.dto.CommentDto;
import de.imker.dto.CommentsListDto;
import de.imker.dto.NewCommentDto;
import de.imker.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentsController implements CommentApi {
  private final CommentsService commentsService;

  @Override
  public CommentDto addComment(NewCommentDto newComment) {
    return commentsService.addComment(newComment);
  }

  @Override
  public CommentsListDto getAllPostComments(Long postId) {
    return commentsService.getAllPostComments(postId);
  }

  @Override
  public CommentsListDto getAllEventComments(Long eventId) {
    return commentsService.getAllEventComments(eventId);
  }

  @Override
  public CommentDto deleteCommentById(Long commentId) {
    return commentsService.deleteCommentById(commentId);
  }
}
