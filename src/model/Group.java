package model;

import exceptions.NoStudentException;

import java.util.*;

public class Group{
    private String title;
    FacultyName facultyName;
    List<Student> students = new ArrayList<>();
    Set<Discipline> disciplines = new HashSet<>();

    public Group(String title) {
        this.title = title;
    }

    public void addStudent(Student... sts){
        students.addAll(Arrays.asList(sts));
        for (Student student : students){
            student.setDisciplines(disciplines);
        }
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
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

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public double getAvrMarkForDiscipline(Discipline discipline) throws NoStudentException {
        Collection<Integer> markValues = new ArrayList<>();
        double avrMarkValue;
        int result = 0;
        if (!disciplines.contains(discipline)){
            avrMarkValue = 0;
        }
        else {
            if (students.isEmpty()){
                throw new NoStudentException("There are no students in group " + title);
            }
            else {
                for (Student student : students){
                    markValues.add(student.getDairy().get(discipline));
                }
                for (Integer integer : markValues){
                    result += integer;
                }
            }
            avrMarkValue = (double) result/markValues.size();
        }
        return avrMarkValue;
    }
    public void printAvrMarkForDiscipline(Discipline discipline) throws NoStudentException {
        if (getAvrMarkForDiscipline(discipline) == 0){
            throw new NoStudentException("There is no discipline " + discipline.getTitle() + " in group " + title + "group.");
        } else {
            System.out.println("Average mark for discipline " + discipline.getTitle() + " in group " + title + " is " + getAvrMarkForDiscipline(discipline));
        }
    }
//-------------------------- Methods to print to console (redundant for the main task) ---------------------------------
//                                            Schedule

    public void printSchedule(){
        System.out.println("List of disciplines of " + title + " group:");
        for (Discipline discipline : disciplines){
            System.out.println(discipline.getTitle());
        }
    }

//                                          Students list

    public void printStudents() throws NoStudentException {
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
