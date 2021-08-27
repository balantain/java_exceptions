package model;

import exceptions.NoFacultiesException;
import exceptions.NoGroupsException;
import exceptions.NoStudentsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class University {
    private String universityName;               //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    List<Faculty> faculties = new ArrayList<>(); // Список факультетов, как и студентов, возможно стоит преобразовать в сет, чтобы не было повторений студентов.
    List<Student> students = new ArrayList<>();  // общий список студентов университета должен создаваться из списка групп, которые находятся факультетах

    public University(String universityName) {
        this.universityName = universityName;
    }

    public void addFaculty(Faculty... fcs){
        faculties.addAll(Arrays.asList(fcs));
    }

    public List<Faculty> getFaculties() throws NoFacultiesException {
        if (faculties.isEmpty()){
            throw new NoFacultiesException("There are no faculties added into the university");
        }
        else return faculties;
    }

    //--------------------------------------------THROW EXCEPTIONS------------------------------------------------------
    public List<Student> getStudents () throws NoStudentsException, NoGroupsException, NoFacultiesException {
        if (faculties.isEmpty()){
            throw new NoFacultiesException();
        }
        else {
            for (Faculty faculty : faculties){
                for (Group group : faculty.getGroups()){
                    students.addAll(group.getStudents());
                }
            }
            return students;
        }
    }
    //------------------- Есть сомнения по поводу данного метода, как поступить, если студент не найден? ---------------
    public Student getStudentByName(String name) throws NoStudentsException, NoGroupsException, NoFacultiesException {
        students = getStudents();
        Student std = null;
        if (students.isEmpty()){
            throw new NoStudentsException("There are no students in the university");
        }
        else {
            for (Student student : students){
                if (name.equals(student.getName())){
                    std = student;
                    break;
                }
                else{
                    throw new NoStudentsException("There is no student with such name in the University");
                }
            }
        }
        return std;
    }

//----------------------------------------------------------------------------------------------------------------------
    public void printStudents () throws NoStudentsException, NoGroupsException, NoFacultiesException {
        if (faculties.isEmpty()){
            throw new NoFacultiesException();
        }
        else {
            for (Faculty faculty : faculties){
                for (Group group : faculty.getGroups()){
                    students.addAll(group.getStudents());
                }
            }
            System.out.println("List of all students in " + universityName + ":");
            for (Student student : students){
                System.out.println(student.getName());
            }
        }
    }
    //------------------------------------Вспомогательный метод для простоты вывода в консоль ------------------------------
    public void printFaculties() throws NoFacultiesException { // возможно также стоит проверить на null!!!!!!!!!
        if (faculties.isEmpty()){
            throw new NoFacultiesException("There are no faculties in the university");
        }
        else {
            System.out.println("List of all faculties of " + universityName + ":");
            for (Faculty faculty : faculties){
                System.out.println(faculty.getFacultyName());
            }
        }
    }
}