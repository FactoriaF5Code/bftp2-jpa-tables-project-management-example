`@OneToOne` and `@OneToMany` examples with JPA and Spring.


- A `project` (class Project) has one `manager` (class Person)
- A `project` (class Project) has a team of many persons (class Person)

|Method| Endpoint | Description |
|------|------|------|
| GET | `/api/projects` | all projects |
| GET | `/api/persons` | all people |
| GET | `/api/projects?personId={id}`| only projects assigned to manager with id `id` |
| DELETE | `/api/persons/{id}` | Removes a person.  |

❗️A person cannot be removed if it's included in a project. To be able to do that, you have to modify the `@OneToManyAnnotation`
in class `Project`:

```java
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> team;
```

if you do this, then you will see the following error: 

```
detached entity passed to persist
```

