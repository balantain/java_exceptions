package model;

import exceptions.NoGroupsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Faculty {
    FacultyName facultyName;
    List<Group> groups = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Discipline> schedule = new ArrayList<>(); // возможно стоит заменить на HashSet, чтобы не возможно было добавить два раза один и тот же предмет.

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public void addGroup(Group... grs) {
        for (Group group : grs) {
            group.schedule = schedule;
        }
        groups.addAll(Arrays.asList(grs));
    }

    public String getFacultyName() {
        return facultyName.getTitle();
    }

    public List<Discipline> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Discipline> schedule) {
        this.schedule = schedule;
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public List<Group> getGroups() throws NoGroupsException {
        if (groups.isEmpty()) {
            throw new NoGroupsException();
        } else {
            return groups;
        }
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Student> getStudents() {
        for (Group group : groups){
            students.addAll(group.students);
        }
        return students;
    }

//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public void addDisciplines(Discipline... disciplines) {
        schedule = Arrays.asList(disciplines);
    }


//------------------------------------Вспомогательные методы для простоты вывода в консоль -----------------------------
//                                                РАССПИСАНИЕ
    public void printSchedule() {
        System.out.println("List of disciplines of " + facultyName.getTitle() + " faculty:");
        for (Discipline discipline : schedule) {
            System.out.println(discipline.getTitle());
        }
    }

//                                               СПИСОК ГРУПП
    public void printGroups() throws NoGroupsException {
        if (groups.size() != 0) {
            System.out.println("List of all groups in " + facultyName.getTitle() + " faculty:");
            for (Group group : groups) {
                System.out.println(group.getTitle());
            }
        } else {
            throw new NoGroupsException("There are no groups in the faculty!");
        }
    }
}
