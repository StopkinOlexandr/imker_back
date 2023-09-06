package de.imker.services;

import de.imker.dto.CommentDto;
import de.imker.dto.CommentsListDto;
import de.imker.dto.NewCommentDto;

public interface CommentsService {
  CommentDto addComment(NewCommentDto newComment);

  CommentsListDto getAllPostComments(Long postId);

  CommentsListDto getAllEventComments(Long eventId);

  CommentDto deleteCommentById(Long commentId);
}
