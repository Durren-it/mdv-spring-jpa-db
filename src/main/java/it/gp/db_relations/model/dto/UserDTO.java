package it.gp.db_relations.model.dto;

import it.gp.db_relations.model.dto.PostDTO;
import it.gp.db_relations.model.dto.ProjectDTO;
import it.gp.db_relations.model.dto.UserDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private UserDetailsDTO userDetails;
    private List<PostDTO> posts;
    private List<ProjectDTO> projects;
}
