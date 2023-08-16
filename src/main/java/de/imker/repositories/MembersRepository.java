package de.imker.repositories;

import de.imker.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MembersRepository extends JpaRepository<Member, Integer> {

  Member getMemberById(Integer memberId);
}
