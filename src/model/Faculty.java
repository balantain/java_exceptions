package model;

import exceptions.NoDisciplineException;
import exceptions.NoGroupException;
import exceptions.NoStudentException;

import java.util.*;

public class Faculty {
    FacultyName facultyName;
    Set<Group> groups = new HashSet<>();
    List<Student> students = new ArrayList<>();
    Set<Discipline> disciplines = new HashSet<>();

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public void addGroup(Group... grs) {
        for (Group group : grs) {
            group.disciplines = disciplines;
            group.facultyName = facultyName;
        }
        groups.addAll(Arrays.asList(grs));
    }

    public String getFacultyName() {
        return facultyName.getTitle();
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public Set<Group> getGroups() throws NoGroupException {
        if (groups.isEmpty()) {
            throw new NoGroupException("There are no groups in " + facultyName.getTitle());
        } else {
            return groups;
        }
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public List<Student> getStudents() throws NoGroupException, NoStudentException {
        students.clear();
        if (groups.isEmpty()){
            throw new NoGroupException("There are no groups in " + facultyName.getTitle());
        }
        for (Group group : groups){
            if (group.students.isEmpty()){
                throw new NoStudentException("There are no students in group " + group.getTitle());
            }
            else {
                students.addAll(group.students);
            }
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public double getAvrMarkForDiscipline(Discipline discipline) throws NoGroupException, NoStudentException {
        Collection<Double> groupAvrMarkValues = new ArrayList<>();
        double groupAvrMarkValue;
        double result = 0;
        if (groups.isEmpty()){
            throw new NoGroupException("There are no groups in " + facultyName.getTitle());
        }
        else {
            if (!disciplines.contains(discipline)){
                groupAvrMarkValue = 0;
            }
            else {
                for (Group group : groups){
                    if (group.getAvrMarkForDiscipline(discipline) != 0) {
                        groupAvrMarkValues.add(group.getAvrMarkForDiscipline(discipline));
                    }
                }
                for (Double groupAvrValue  : groupAvrMarkValues){
                    result += groupAvrValue;
                }
                groupAvrMarkValue = result/groupAvrMarkValues.size();
            }
        }
        return groupAvrMarkValue;
    }

    public void printAvrMarkForDiscipline(Discipline discipline) throws NoGroupException, NoStudentException, NoDisciplineException {
        if (getAvrMarkForDiscipline(discipline) == 0){
            throw new NoDisciplineException("There is no discipline" + discipline.getTitle() +  " in " + facultyName.getTitle());
        }
        else {
            System.out.println("Average mark for discipline " + discipline.getTitle() + " in " + facultyName.getTitle() + " is " + getAvrMarkForDiscipline(discipline));
        }
    }

    public void addDisciplines(Discipline... disciplines) {
        this.disciplines.addAll(Arrays.asList(disciplines));
    }


//------------------------------------ Methods to print to console -----------------------------
//                                             Schedule
    public void printSchedule() {
        System.out.println("List of disciplines of " + facultyName.getTitle() + " faculty:");
        for (Discipline discipline : disciplines) {
            System.out.println(discipline.getTitle());
        }
    }

//                                              Groups

    public void printGroups() throws NoGroupException {
        if (groups.size() != 0) {
            System.out.println("List of all groups in " + facultyName.getTitle() + " faculty:");
            for (Group group : groups) {
                System.out.println(group.getTitle());
            }
        } else {
            throw new NoGroupException("There are no groups in the faculty!");
        }
    }
}
