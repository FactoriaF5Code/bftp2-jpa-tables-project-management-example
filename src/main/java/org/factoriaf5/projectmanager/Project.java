package org.factoriaf5.projectmanager;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int budgetInMillions;

    @OneToOne
    private Person manager;

    @OneToMany
    private Set<Person> team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBudgetInMillions() {
        return budgetInMillions;
    }

    public void setBudgetInMillions(int budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public Set<Person> getTeam() {
        return team;
    }

    public void setTeam(Set<Person> team) {
        this.team = team;
    }
}
