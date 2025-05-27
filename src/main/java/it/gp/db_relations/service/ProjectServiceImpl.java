package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.ProjectDTO;
import it.gp.db_relations.model.entity.Project;
import it.gp.db_relations.model.entity.User;
import it.gp.db_relations.repository.ProjectRepository;
import it.gp.db_relations.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private ProjectDTO toDTO(Project project) {
        List<Long> userIds = project.getUsers().stream().map(User::getId).collect(Collectors.toList());
        return new ProjectDTO(
                project.getId(),
                project.getName(),
                userIds
        );
    }

    private Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        return optionalProject.orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
