package org.factoriaf5.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final PersonRepository personRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, PersonRepository personRepository) {
        this.projectRepository = projectRepository;
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Project> allProjects(@RequestParam(required = false) Long personId) {
        if (personId == null) {
            return projectRepository.findAll();
        }
        Person p = personRepository.findById(personId).orElseThrow(ManagerNotFoundException::new);
        return projectRepository.findAllByManager(p);
    }
}
