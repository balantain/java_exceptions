package model;

import exceptions.NoStudentsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group{
    // конструктор группы можно сразу настроить для добавления любого количества студентов
    private String title;
    List<Student> students;
    List<Discipline> schedule;

    public Group(String title) {
        this.title = title;
    }

    public void addStudent(Student... sts){ // добавление студентов в группу
        Collections.addAll(students, sts);
        for (Student student : sts){
            student.schedule = schedule;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
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

    public void printSchedule(){                                    // вывод на печать списка дисциплин в группе
        System.out.println("List of disciplines of " + title + " group:");
        for (Discipline discipline : schedule){
            System.out.println(discipline.getTitle());
        }
    }

    public void printStudents() throws NoStudentsException {        // вывод на печать списка студентов в группе
        if (!students.isEmpty()){
            System.out.println("List of students of " + title + " group:");
            for (Student student : students){
                System.out.println(student.getName());
            }
        }
        else {
            throw new NoStudentsException("There are no students in group!");
        }
    }
}
