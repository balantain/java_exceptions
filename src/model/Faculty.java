package model;

import exceptions.NoDisciplineException;
import exceptions.NoGroupException;
import exceptions.NoStudentException;

import java.util.*;

public class Faculty {
    FacultyName facultyName;
    List<Group> groups = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Discipline> schedule = new ArrayList<>(); // возможно стоит заменить на HashSet, чтобы не возможно было добавить два раза один и тот же предмет.

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public void addGroup(Group... grs) {
        for (Group group : grs) {
            group.schedule = schedule;
            group.facultyName = facultyName;
        }
        groups.addAll(Arrays.asList(grs));
    }

    public String getFacultyName() {
        return facultyName.getTitle();
    }

    public List<Discipline> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Discipline> schedule) {
        this.schedule = schedule;
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public List<Group> getGroups() throws NoGroupException {
        if (groups.isEmpty()) {
            throw new NoGroupException("There are no groups in " + facultyName.getTitle());
        } else {
            return groups;
        }
    }

    public void setGroups(List<Group> groups) {
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
// NEED TO OVERRIDE THIS METHOD TO GET AVERAGE VALUE FROM EACH GROUP (group.countAvrMarkValueForDiscipline(Discipline discipline))

    public double getAvrMarkForDiscipline(Discipline discipline) throws NoGroupException, NoStudentException, NoDisciplineException {
        Collection<Double> groupAvrMarkValues = new ArrayList<>();
        double result = 0;
        if (groups.isEmpty()){
            throw new NoGroupException("There are no groups in " + facultyName.getTitle());
        }
        else {
            for (Group group : groups){
                groupAvrMarkValues.add(group.getAvrMarkForDiscipline(discipline));
            }
        }
        for (Double groupAvrValue  : groupAvrMarkValues){
            result += groupAvrValue;
        }
        return result/groupAvrMarkValues.size();
    }
    public void printAvrMarkForDiscipline(Discipline discipline) throws NoGroupException, NoDisciplineException, NoStudentException {
        System.out.println("Average mark for discipline " + discipline.getTitle() + " in " + facultyName.getTitle() + " is " + getAvrMarkForDiscipline(discipline));
    }

    public void addDisciplines(Discipline... disciplines) {
        schedule = Arrays.asList(disciplines);
    }


//------------------------------------Вспомогательные методы для простоты вывода в консоль -----------------------------
//                                                РАССПИСАНИЕ
    public void printSchedule() {
        System.out.println("List of disciplines of " + facultyName.getTitle() + " faculty:");
        for (Discipline discipline : schedule) {
            System.out.println(discipline.getTitle());
        }
    }

//                                               СПИСОК ГРУПП
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
