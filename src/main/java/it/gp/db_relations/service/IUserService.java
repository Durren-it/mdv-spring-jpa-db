package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.UserDTO;
import it.gp.db_relations.model.entity.User;
import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
}
