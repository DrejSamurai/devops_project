package finki.ukim.mk.projectmanager.services.impl;

import finki.ukim.mk.projectmanager.dtos.ProjectDTO;
import finki.ukim.mk.projectmanager.models.Project;
import finki.ukim.mk.projectmanager.repository.ProjectRepository;
import finki.ukim.mk.projectmanager.services.interfaces.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {


    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> findAllProjects() {
        return modelToDto(projectRepository.findAll());
    }

    @Override
    public ProjectDTO modelToDto(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setDateBeginning(project.getDateBeginning());
        projectDTO.setDateEnding(project.getDateEnding());
        projectDTO.setIsActive(project.getIsActive());
        return projectDTO;
    }

    @Override
    public List<ProjectDTO> modelToDto(List<Project> projects) {
        return projects.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    @Override
    public void addProject(ProjectDTO projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setDateBeginning(projectDto.getDateBeginning());
        project.setDateEnding(projectDto.getDateEnding());
        project.setIsActive(projectDto.getIsActive());
        projectRepository.save(project);
    }

    @Override
    public void updateProject(ProjectDTO projectDto) {
        Long id = projectDto.getId();
        Project project = this.projectRepository.findById(id).get();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setDateBeginning(projectDto.getDateBeginning());
        project.setDateEnding(projectDto.getDateEnding());
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
