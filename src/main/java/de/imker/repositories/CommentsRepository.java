package de.imker.repositories;

import de.imker.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

  List<Comment> findAllByPostId(Long postId);

  List<Comment> findAllByEventId(Long eventId);

    Comment findCommentById(Long commentId);
}
