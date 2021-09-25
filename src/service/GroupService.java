package service;

import exceptions.NoDisciplineException;
import exceptions.NoStudentException;
import model.Discipline;
import model.Group;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class GroupService {

    public static void addStudentsToGroup (Group group, Student... sts){
        Random random = new Random();
        for (Student student : sts){
            for (Discipline discipline : group.getDisciplines()){
                student.getDairy().put(discipline, (random.nextInt(10) + 1));
            }
            group.getStudents().add(student);
        }
    }

    public static float countAvrMarkForDiscipline(Group group, Discipline discipline) throws NoStudentException {
        Collection<Integer> markValues = new ArrayList<>();
        float avrMarkValue;
        int result = 0;
        if (!group.getDisciplines().contains(discipline)){
            avrMarkValue = 0;
        }
        else {
            if (group.getStudents().isEmpty()){
                throw new NoStudentException("There are no students in group " + group.getName());
            }
            else {
                for (Student student : group.getStudents()){
                    markValues.add(student.getDairy().get(discipline));
                }
                for (Integer integer : markValues){
                    result += integer;
                }
            }
            avrMarkValue = (float) result/markValues.size();
        }
        return avrMarkValue;
    }

    public static void printAvrMarkForDiscipline(Group group, Discipline discipline) throws NoStudentException, NoDisciplineException {
        if (countAvrMarkForDiscipline(group, discipline) == 0){
            throw new NoDisciplineException("There is no discipline " + discipline.getTitle() + " in group " + group.getName() + "group.");
        } else {
            System.out.println("Average mark for discipline " + discipline.getTitle() + " in group " + group.getName() + " is " + countAvrMarkForDiscipline(group, discipline) + "\n");
        }
    }

    //------------------------------------------ Redundant methods to check myself -----------------------------------------

    public static void printGroupStudentList(Group group) throws NoStudentException {
        if (!group.getStudents().isEmpty()){
            System.out.println("List of students of " + group.getName() + " group:");
            for (Student student : group.getStudents()){
                StudentService.printStudentInfo(student);
                System.out.println();
            }
        }
        else {
            throw new NoStudentException("There are no students in group " + group.getName());
        }
    }
    public void printDisciplines(Group group){
        System.out.println("List of disciplines in " + group.getName() + " group:");
        for (Discipline discipline : group.getDisciplines()){
            System.out.println(discipline.getTitle());
        }
    }
}