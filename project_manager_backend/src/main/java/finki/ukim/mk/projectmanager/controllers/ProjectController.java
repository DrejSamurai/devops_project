package finki.ukim.mk.projectmanager.controllers;

import finki.ukim.mk.projectmanager.dtos.ProjectDTO;
import finki.ukim.mk.projectmanager.services.interfaces.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/projects")
public class ProjectController {

    public final ProjectService projectService;
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/getAll")
    public List<ProjectDTO> findAllProjects(){
        return projectService.findAllProjects();
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/addProject")
    public void addProject(@RequestBody ProjectDTO projectDto){
        projectService.addProject(projectDto);
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/updateProject")
    public void updateProject(@RequestBody ProjectDTO projectDto){
        projectService.updateProject(projectDto);
    }

    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable("id") Long id){
        projectService.deleteProject(id);
    }
}
