package finki.ukim.mk.projectmanager.services.interfaces;

import finki.ukim.mk.projectmanager.dtos.ProjectDTO;
import finki.ukim.mk.projectmanager.models.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> findAllProjects();
    ProjectDTO modelToDto(Project project);
    List<ProjectDTO> modelToDto(List<Project> getAll);
    void addProject(ProjectDTO projectDto);
    void updateProject(ProjectDTO projectDto);
    void deleteProject(Long id);

}
