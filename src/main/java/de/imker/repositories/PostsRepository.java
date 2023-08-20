package de.imker.repositories;

import de.imker.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostsRepository extends JpaRepository<Post, Long> {
  Optional<Post> getPostById(Long idPost);

}
