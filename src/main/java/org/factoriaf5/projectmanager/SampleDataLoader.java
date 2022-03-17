package org.factoriaf5.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        var p1 = personRepository.save(person("Pepa", "Díaz", "pepadiaz@example.com"));
        var p2 = personRepository.save(person("Rosa", "Pérez", "rosaperez@example.com"));
        var p3 = person("Paqui", "Pérez", "paquiperez@example.com");
        var p4 = person("Valentina", "Pérez", "valeperez@example.com");
        var p5 = person("Marta", "Pérez", "martaperez@example.com");
        var p6 = person("Lola", "Pérez", "lolaperez@example.com");

        projectRepository.saveAll(List.of(
                project("Particle Accelerator", 10000, p1, p3,p4),
                project("International Space Station", 800000, p2, p5, p6)
        ));
    }

    private Project project(String name, int budget, Person manager, Person... teamMembers) {
        var p = new Project();
        p.setName(name);
        p.setBudgetInMillions(budget);
        p.setManager(manager);
        Set<Person> team = Stream.of(teamMembers).collect(Collectors.toSet());
        p.setTeam(team);
        team.forEach(person -> person.setProject(p));
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
