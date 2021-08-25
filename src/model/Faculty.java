package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Faculty {
    FacultyName facultyName;
    List<Group> groups = new ArrayList<>();
    Schedule schedule = new Schedule();

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }
    public void addGroup(Group... grs){
        Collections.addAll(groups, grs);
    }

    public String getFacultyName() {
        return facultyName.getTitle();
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }
}
