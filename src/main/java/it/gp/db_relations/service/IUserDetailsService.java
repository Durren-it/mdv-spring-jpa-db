package it.gp.db_relations.service;

import it.gp.db_relations.model.entity.UserDetails;
import java.util.List;

public interface IUserDetailsService {
    List<UserDetails> getAllUserDetails();
    UserDetails getUserDetailsById(Long id);
    UserDetails createUserDetails(UserDetails userDetails);
}
