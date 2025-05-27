package it.gp.db_relations.service;

import it.gp.db_relations.model.entity.User;
import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
}
