package it.gp.db_relations.service;

import it.gp.db_relations.model.entity.Project;
import java.util.List;

public interface IProjectService {
    List<Project> getAllProjects();
    Project getProjectById(Long id);
    Project createProject(Project project);
}
