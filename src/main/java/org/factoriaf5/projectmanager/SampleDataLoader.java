package org.factoriaf5.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {


    private PersonRepository personRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public SampleDataLoader(PersonRepository personRepository, ProjectRepository projectRepository) {
        this.personRepository = personRepository;
        this.projectRepository = projectRepository;
    }


    @PostConstruct
    private void loadSampleData() {
        personRepository.saveAll(List.of(
                person("Pepa", "Díaz", "pepadiaz@example.com"),
                person("Rosa", "Pérez", "rosaperez@example.com")
        ));

        projectRepository.saveAll(List.of(
                project("Particle Accelerator", 10000),
                project("International Space Station", 800000)
        ));


    }

    private Project project(String name, int budget) {
        var p = new Project();
        p.setName(name);
        p.setBudgetInMillions(budget);
        return p;
    }

    private Person person(String firstName, String lastName, String email) {
        var p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);
        return p;
    }


}
