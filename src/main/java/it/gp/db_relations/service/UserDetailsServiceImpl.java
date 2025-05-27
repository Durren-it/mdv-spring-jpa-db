package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.UserDetailsDTO;
import it.gp.db_relations.model.entity.User;
import it.gp.db_relations.model.entity.UserDetails;
import it.gp.db_relations.repository.UserDetailsRepository;
import it.gp.db_relations.service.IUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    private UserDetailsDTO toDTO(UserDetails details) {
        return new UserDetailsDTO(
                details.getId(),
                details.getAddress(),
                details.getPhoneNumber(),
                details.getUser().getId()
        );
    }

    private UserDetails toEntity(UserDetailsDTO dto) {
        UserDetails details = new UserDetails();
        details.setId(dto.getId());
        details.setAddress(dto.getAddress());
        details.setPhoneNumber(dto.getPhoneNumber());
        return details;
    }

    @Override
    public List<UserDetailsDTO> getAllUserDetails() {
        return userDetailsRepository.findAll().stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDetailsDTO getUserDetailsById(Long id) {
        Optional<UserDetails> optionalUserDetails = userDetailsRepository.findById(id);
        return optionalUserDetails.map(this::toDTO).orElse(null);
    }

    @Override
    public UserDetailsDTO createUserDetails(UserDetailsDTO userDetailsDTO) {
        return toDTO(userDetailsRepository.save(
                toEntity(userDetailsDTO)
        ));
    }
}
