package de.imker.repositories;

import de.imker.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Post, Long> {
  Optional<Post> getPostByIdPost(Long idPost);
  @Query("SELECT p FROM Post p ORDER BY p.creationTimePost DESC")
  List<Post> findAllOrderByCreationTimePost();
}
