package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.UserDetailsDTO;
import it.gp.db_relations.model.entity.UserDetails;
import java.util.List;

public interface IUserDetailsService {
    List<UserDetailsDTO> getAllUserDetails();
    UserDetailsDTO getUserDetailsById(Long id);
    UserDetailsDTO createUserDetails(UserDetailsDTO userDetailsDTO);
}
