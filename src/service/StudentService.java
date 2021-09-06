package service;

import exceptions.MarkValueException;
import exceptions.NoDisciplineException;
import model.Discipline;
import model.Student;

import java.util.Map;
import java.util.Random;

public class StudentService {

    public static void printStudentInfo (Student student){
        System.out.print(student.getName() + " | ");
        for (Discipline discipline : student.getDairy().keySet()){
            System.out.print(discipline.getTitle() + " - " + student.getDairy().get(discipline) + " | ");
        }
    }

// Count average value for all disciplines of a student-----------------------------------------------------------------
    public static void printAvrMarkForStudentDairy (Student student) throws MarkValueException, NoDisciplineException {
        int result = 0;
        if (student.getDairy().isEmpty()){
            throw new NoDisciplineException("There are no disciplines in " + student.getName() + " dairy.");
        }
        for (Discipline discipline : student.getDairy().keySet()){
            if (student.getDairy().get(discipline) < 0 || student.getDairy().get(discipline) > 10){
                throw new MarkValueException("Student's mark for " + discipline.getTitle() + " is not in diapason between 0 and 10.");
            }
            result += student.getDairy().get(discipline);
        }
        System.out.println("Average mark value for student " + student.getName() + " is: " + (result / student.getDairy().size()) + "\n");
    }
}
