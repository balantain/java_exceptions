package model;

import exceptions.NoFacultyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private String universityName;
    List<Faculty> faculties = new ArrayList<>();
    List<Student> students = new ArrayList<>(); // общий список студентов университета должен создаваться из списка групп, которые находятся факультетах

    public University(String universityName) {
        this.universityName = universityName;
    }

    public void addFaculty(Faculty... fcs){
        Collections.addAll(faculties, fcs);
    }

    public void printFaculties() throws NoFacultyException {
        if (faculties.size() == 0){
            throw new NoFacultyException("There are no faculties in university");
        }
        else {
            for (Faculty faculty : faculties){
                System.out.println(faculty.getFacultyName());
            }
        }
    }
}
