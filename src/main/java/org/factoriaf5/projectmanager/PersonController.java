package org.factoriaf5.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> allPersons() {
        return personRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Long id) {
        var person = personRepository.findById(id)
                .orElseThrow(PersonNotFoundException::new);

        person.getProject().removeTeamMember(person);
        personRepository.delete(person);
    }
}
