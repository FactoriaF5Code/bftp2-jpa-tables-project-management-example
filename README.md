`@OneToOne` and `@OneToMany` examples with JPA and Spring.


- A `project` (class Project) has one `manager` (class Person)
- A `project` (class Project) has a team of many persons (class Person)

|Method| Endpoint | Description |
|------|------|------|
| GET | `/api/projects` | all projects |
| GET | `/api/persons` | all people |
| GET | `/api/projects?personId={id}`| only projects assigned to manager with id `id` |

