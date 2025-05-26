package it.gp.db_relations.repository;

import it.gp.db_relations.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
