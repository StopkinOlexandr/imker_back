package de.imker.repositories;


import de.imker.dto.UsersDto;
import de.imker.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<User, Long> {


  Optional<User> findByEmail(String email);

//  @Query("select user from User user where user.role = 'STUDENT' and :course not member of user.courses")
//    List<User> findStudentsNotInCourse(@Param("course") Course course);

  boolean existsByRole(User.Role role);

//  Page<User> findAllByRole(User.Role role, Pageable pageable);
//
//  Page<User> findAllByState(User.State state, Pageable pageable);


}
