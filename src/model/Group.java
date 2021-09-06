package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group{
    private String name;
    private List<Student> students;
    private Set<Discipline> disciplines;



    public Group(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents(){
        if (students == null){
            students = new ArrayList<>();
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
