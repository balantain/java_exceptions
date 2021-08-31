package model;

import exceptions.*;

import java.util.*;

public class University {

    private String universityName;
    Set<Faculty> faculties = new HashSet<>();
    List<Student> students = new ArrayList<>();
    List<Discipline> disciplineList = new ArrayList<>();

//----------------------------------------------- Constructors ---------------------------------------------------------
    public University() {

    }
    public University(String universityName) {
        this.universityName = universityName;
    }
//--------------------------------------------- Getters & Setters ------------------------------------------------------
    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Set<Faculty> getFaculties() throws NoFacultyException {
        if (faculties.isEmpty()){
            throw new NoFacultyException("There are no faculties added into the university");
        }
        else return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public void addFaculty(Faculty... fclts){
        for (Faculty faculty : fclts){
            faculty.schedule.addAll(disciplineList);
        }
        faculties.addAll(Arrays.asList(fclts));
    }

    public void addDisciplines(Discipline... disciplines) throws NoGroupException {
        disciplineList.addAll(Arrays.asList(disciplines));
        for (Faculty faculty : faculties){
            faculty.schedule.addAll(Arrays.asList(disciplines));
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
    public double getAvrMarkValueForDiscipline(Discipline discipline) throws NoGroupException, NoStudentException, NoDisciplineException {
        Collection<Double> facultyAvrMarkValues = new ArrayList<>();
        double result = 0;
        double universityAvrMarkValue = 0;
        for (Faculty faculty : faculties){
            if (faculty.getAvrMarkForDiscipline(discipline) != 0){
                facultyAvrMarkValues.add(faculty.getAvrMarkForDiscipline(discipline));
            }
        }
        if (facultyAvrMarkValues.size() != 0){
            for (Double facultyAvrMarkValue : facultyAvrMarkValues){
                result += facultyAvrMarkValue;
            }
            universityAvrMarkValue = result/facultyAvrMarkValues.size();
        } else {
            throw new NoDisciplineException("There is no such discipline in the university");
        }
        return universityAvrMarkValue;
    }
    public void printAvrMarkValueForDiscipline(Discipline discipline) throws NoDisciplineException, NoGroupException, NoStudentException {
        if (getAvrMarkValueForDiscipline(discipline) == 0){
            throw new NoDisciplineException("There is no discipline " + discipline.getTitle() + " in university" + universityName);
        }
        else {
            System.out.println("The average mark value for discipline " + discipline.getTitle() + " in university " + universityName + " is: " + getAvrMarkValueForDiscipline(discipline));
        }
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