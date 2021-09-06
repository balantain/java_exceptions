package model;


import java.util.HashSet;
import java.util.Set;

public class Faculty {
    private FacultyName facultyName;
    private Set<Group> groups;
    private Set<Discipline> disciplines;



    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }



    public FacultyName getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public Set<Group> getGroups() {
        if (groups == null) {
            groups = new HashSet<>();
        }
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Discipline> getDisciplines() {
        if (disciplines == null){
            disciplines = new HashSet<>();
        }
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
