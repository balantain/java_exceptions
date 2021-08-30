package model;

import exceptions.*;

import java.util.*;

public class University {
    private String universityName;               //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    List<Faculty> faculties = new ArrayList<>(); // Список факультетов, как и студентов, возможно стоит преобразовать в сет, чтобы не было повторений студентов.
    List<Student> students = new ArrayList<>();  // общий список студентов университета должен создаваться из списка групп, которые находятся факультетах

    public University(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addFaculty(Faculty... fcs){
        faculties.addAll(Arrays.asList(fcs));
    }

    public List<Faculty> getFaculties() throws NoFacultyException {
        if (faculties.isEmpty()){
            throw new NoFacultyException("There are no faculties added into the university");
        }
        else return faculties;
    }

    public List<Student> getStudents () throws NoStudentException, NoGroupException, NoFacultyException {
        if (faculties.isEmpty()){
            throw new NoFacultyException();
        }
        else {
            students.clear();
            for (Faculty faculty : faculties){
                for (Group group : faculty.getGroups()){
                    students.addAll(group.getStudents());
                }
            }
            return students;
        }
    }

//------------------- Есть сомнения по поводу данного метода, как поступить, если студент не найден? ---------------
    public Student getStudentByName(String name) throws NoStudentException, NoGroupException, NoFacultyException {
        Student std = null;
        if (students.isEmpty()){
            throw new NoStudentException("There are no students in the university");
        }
        else {
            for (Student student : students){
                if (name.equals(student.getName())){
                    std = student;
                    break;
                }
            }
        }
        if (std == null){
            throw new NoStudentException("There are no such student in the university");
        }
        return std;
    }

    public void setRandomMarksForStudents (List<Student> studentList) throws NoDisciplineException, MarkValueException {
        for (Student student : studentList){
            student.setRandomMarksToDairy();
        }
    }

    public void countAvrMarkValueForStudentDairy(Student student) throws NoDisciplineException {
        double avrMarkValue = 0;
        if (student.getDairy().isEmpty()){
            throw new NoDisciplineException("There are no disciplines in student's dairy");
        }
        else {
            Collection<Integer> markValues = student.getDairy().values();
            int result = 0;
            for (Integer integer : markValues){
                result += integer;
            }
            avrMarkValue = (double) result/markValues.size();
        }
        System.out.println("Average mark value for student " + student + " is: " + avrMarkValue);
    }

//-------------------------------Вспомогательный метод для простоты вывода в консоль списка факультетов-----------------
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