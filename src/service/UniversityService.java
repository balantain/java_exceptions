package service;

import exceptions.NoDisciplineException;
import exceptions.NoFacultyException;
import exceptions.NoGroupException;
import exceptions.NoStudentException;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityService {

    public static void addUniversityFaculties (University university, Faculty... fcs){
        university.getFaculties().addAll(Arrays.asList(fcs));
    }

    public static List<Student> getStudentList (University university){
        List<Student> students = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()){
            students.addAll(FacultyService.getFacultyStudentList(faculty));
        }
        return students;
    }

    public static Student getStudentByName(University university, String name) throws NoStudentException {
        Student std = null;
        for (Student student : UniversityService.getStudentList(university)){
            if (name.equals(student.getName())){
                std = student;
                break;
            }
        }
        if (std == null){
            throw new NoStudentException("There is no student with name " + name + " in " + university.getUniversityName() + " university");
        }
        return std;
    }


    public static float countAvrMarkValueForDiscipline(University university, Discipline discipline) throws NoGroupException, NoStudentException {
        List<Float> facultyAvrMarkValues = new ArrayList<>();
        float result = 0;
        float universityAvrMarkValue = 0;
        for (Faculty faculty : university.getFaculties()){
            if (FacultyService.countAvrMarkForDiscipline(faculty, discipline) != 0){
                facultyAvrMarkValues.add(FacultyService.countAvrMarkForDiscipline(faculty, discipline));
            }
        }
        if (facultyAvrMarkValues.size() != 0){
            for (Float facultyAvrMarkValue : facultyAvrMarkValues){
                result += facultyAvrMarkValue;
            }
            universityAvrMarkValue = result/facultyAvrMarkValues.size();
        }
        return universityAvrMarkValue;
    }

    public static void printAvrMarkValueForDiscipline(University university, Discipline discipline) throws NoDisciplineException, NoGroupException, NoStudentException {
        if (countAvrMarkValueForDiscipline(university, discipline) == 0){
            throw new NoDisciplineException("There is no discipline " + discipline.getTitle() + " in university" + university.getUniversityName());
        }
        else {
            System.out.println("The average mark value for discipline " + discipline.getTitle() + " in university " + university.getUniversityName() + " is: " + countAvrMarkValueForDiscipline(university, discipline) + "\n");
        }
    }

//------------------------------------------ Redundant methods to check myself -----------------------------------------

    public static void printUniversityFaculties(University university) throws NoFacultyException {
        if (university.getFaculties().isEmpty()){
            throw new NoFacultyException("There are no faculties in the university");
        }
        System.out.println("List of all faculties of " + university.getUniversityName() + ":");
        for (Faculty faculty : university.getFaculties()){
            System.out.println(faculty.getFacultyName().getTitle());
        }
        System.out.println();
    }

    public static void printListOfAllStudentsWithDairy(University university){
        System.out.println("List of all " + UniversityService.getStudentList(university).size() + "students in " + university.getUniversityName() + ":");
        for (Student student : UniversityService.getStudentList(university)) {
            StudentService.printStudentInfo(student);
            System.out.println();
        }
        System.out.println();
    }

    public static Faculty getUniversityFaculty(University university, FacultyName facultyName) throws NoFacultyException {
        Faculty fcl = null;
        for (Faculty faculty : university.getFaculties()){
            if (facultyName.equals(faculty.getFacultyName())){
                fcl = faculty;
            }
        }
        if (fcl == null){
            throw new NoFacultyException("There is no faculty " + facultyName + " in university " + university.getUniversityName());
        }
        return fcl;
    }
}