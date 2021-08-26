package model;

import exceptions.NoGroupException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Faculty {
    FacultyName facultyName;
    List<Group> groups = new ArrayList<>();
    List<Student> students = new ArrayList<>();
//    Schedule schedule = new Schedule(); // создать список дисциплин для данного факультета
    List<Discipline> schedule = new ArrayList<>(); // возможно стоит заменить на HashSet, чтобы не возможно было добавить два раза один и тот же предмет.

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }
    public void addGroup(Group... grs){
        Collections.addAll(groups, grs);
    }

    public String getFacultyName() {
        return facultyName.getTitle();
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }
    public void addDisciplines(Discipline... disciplines){
        Collections.addAll(schedule, disciplines);
    }

    public void printGroups() throws NoGroupException {
        if ( groups.size() != 0){
            System.out.println("List of all groups in " + facultyName.getTitle() + " faculty:");
            for (Group group : groups){
                System.out.println(group.getTitle());
            }
        }
        else {
            throw new NoGroupException("There are no groups in the faculty!");
        }
    }
}
