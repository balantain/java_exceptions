package service;

import exceptions.NoDisciplineException;
import exceptions.NoGroupException;
import exceptions.NoStudentException;
import model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FacultyService {
    public static void addFacultyGroups(Faculty faculty, Group... grs) {
        for (Group group : grs){
            group.setDisciplines(faculty.getDisciplines());
            faculty.getGroups().add(group);
        }
    }

    public static List<Student> getFacultyStudentList (Faculty faculty){
        List<Student> students = new ArrayList<>();
        for (Group group : faculty.getGroups()){
            students.addAll(group.getStudents());
        }
        return students;
    }

    public static void addDisciplinesToFaculty(Faculty faculty, Discipline... disciplines) {
        for (Discipline discipline : disciplines){
            faculty.getDisciplines().add(discipline);
        }
    }

    public static float countAvrMarkForDiscipline(Faculty faculty, Discipline discipline) throws NoGroupException, NoStudentException {
        Collection<Float> groupAvrMarkValues = new ArrayList<>();
        float groupAvrMarkValue;
        float result = 0;
        if (faculty.getGroups().isEmpty()){
            throw new NoGroupException("There are no groups in " + faculty.getFacultyName().getTitle());
        }
        if (!faculty.getDisciplines().contains(discipline)){
            groupAvrMarkValue = 0;
        }
        else {
            for (Group group : faculty.getGroups()){
                if (GroupService.countAvrMarkForDiscipline(group, discipline) != 0) {
                    groupAvrMarkValues.add(GroupService.countAvrMarkForDiscipline(group, discipline));
                }
            }
            for (Float groupAvrValue  : groupAvrMarkValues){
                result += groupAvrValue;
            }
            groupAvrMarkValue = result/groupAvrMarkValues.size();
        }
        return groupAvrMarkValue;
    }

    public static void printAvrMarkForDiscipline(Faculty faculty, Discipline discipline) throws NoGroupException, NoStudentException, NoDisciplineException {
        if (countAvrMarkForDiscipline(faculty, discipline) == 0){
            throw new NoDisciplineException("There is no discipline" + discipline.getTitle() +  " in " + faculty.getFacultyName().getTitle());
        }
        System.out.println("Average mark for discipline " + discipline.getTitle() + " in " + faculty.getFacultyName().getTitle() + " is " + countAvrMarkForDiscipline(faculty, discipline) + "\n");
    }

//------------------------------------------ Redundant methods to check myself -----------------------------------------

    public static void printFacultyDisciplines(Faculty faculty) throws NoDisciplineException {
        if (faculty.getDisciplines().isEmpty()){
            throw new NoDisciplineException("There are no disciplines in " + faculty.getFacultyName().getTitle() + " faculty.");
        }
        System.out.println("List of disciplines of " + faculty.getFacultyName().getTitle() + " faculty:");
        for (Discipline discipline : faculty.getDisciplines()) {
            System.out.println(discipline.getTitle());
        }
        System.out.println();
    }

    public static void printFacultyGroups(Faculty faculty) throws NoGroupException {
        if (faculty.getGroups().isEmpty()) {
            throw new NoGroupException("There are no groups in the faculty!");
        }
        System.out.println("List of all groups in " + faculty.getFacultyName().getTitle() + " faculty:");
        for (Group group : faculty.getGroups()) {
            System.out.println(group.getName());
        }
        System.out.println();
    }
}