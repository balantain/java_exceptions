package model;

import exceptions.NoFacultyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private String universityName;
    List<Faculty> faculties = new ArrayList<>(); // Список факультетов, как и студентов, возможно стоит преобразовать в сет, чтобы не было повторений студентов.
    List<Student> students = new ArrayList<>(); // общий список студентов университета должен создаваться из списка групп, которые находятся факультетах

    public University(String universityName) {
        this.universityName = universityName;
    }

    public void addFaculty(Faculty... fcs){
        Collections.addAll(faculties, fcs);
    }

    public void printFaculties() throws NoFacultyException { // возможно также стоит проверить на null!!!!!!!!!
        if (faculties.isEmpty()){
            throw new NoFacultyException("There are no faculties in the university");
        }
        else {
            System.out.println("List of all faculties of " + universityName + ":");
            for (Faculty faculty : faculties){
                System.out.println(faculty.getFacultyName());
            }
        }
    }
}
