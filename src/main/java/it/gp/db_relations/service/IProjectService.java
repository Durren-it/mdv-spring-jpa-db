package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.ProjectDTO;
import it.gp.db_relations.model.entity.Project;
import java.util.List;

public interface IProjectService {
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(Long id);
    ProjectDTO createProject(ProjectDTO projectDTO);
}
