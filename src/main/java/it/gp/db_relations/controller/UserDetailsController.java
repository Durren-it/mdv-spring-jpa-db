package it.gp.db_relations.controller;

import it.gp.db_relations.model.dto.UserDetailsDTO;
import it.gp.db_relations.model.entity.UserDetails;
import it.gp.db_relations.repository.UserDetailsRepository;
import it.gp.db_relations.service.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class UserDetailsController {

    private final IUserDetailsService userDetailsService;

    public UserDetailsController(IUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public List<UserDetailsDTO> getAllUserDetails() {
        return userDetailsService.getAllUserDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDTO> getDetailsById(@PathVariable Long id) {
        UserDetailsDTO details = userDetailsService.getUserDetailsById(id);
        if (details == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(details);
    }

    @PostMapping
    public UserDetailsDTO createUserDetails(@RequestBody UserDetailsDTO userDetailsDTO) {
        return userDetailsService.createUserDetails(userDetailsDTO);
    }
}
