package model;

import exceptions.NoDisciplineException;
import exceptions.NoStudentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group{
    private String title;
    FacultyName facultyName;
    List<Student> students = new ArrayList<>();
    List<Discipline> schedule = new ArrayList<>();

    public Group(String title) {
        this.title = title;
    }

    public void addStudent(Student... sts){ // добавление студентов в группу
        students.addAll(Arrays.asList(sts));
        for (Student student : students){
            student.setSchedule(schedule); // возможно расписание не передается
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() throws NoStudentException {
        if (students.isEmpty()){
            throw new NoStudentException();
        }
        else {
            return students;
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Discipline> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Discipline> schedule) {
        this.schedule = schedule;
    }
// WORKING WITH THIS METHOD.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void countAvrMarkForDiscipline(Discipline discipline) throws NoDisciplineException, NoStudentException {
        if (!schedule.contains(discipline)){
            throw new NoDisciplineException("There is no such discipline at " + facultyName);
        }
        else {
            if (students.isEmpty()){
                throw new NoStudentException("There are no students in group " + title);
            }
            else {
                for (Student student : students){

                }
            }
        }
    }
//--------------------------------------------- Maybe redundant ---------------------------------------------------
    public void printSchedule(){                                    // вывод на печать списка дисциплин в группе
        System.out.println("List of disciplines of " + title + " group:");
        for (Discipline discipline : schedule){
            System.out.println(discipline.getTitle());
        }
    }

    public void printStudents() throws NoStudentException {        // вывод на печать списка студентов в группе
        if (!students.isEmpty()){
            System.out.println("List of students of " + title + " group:");
            for (Student student : students){
                System.out.println(student.getName());
            }
        }
        else {
            throw new NoStudentException("There are no students in group!");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Group " + title;
    }
}
