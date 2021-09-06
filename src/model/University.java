package model;

import java.util.HashSet;
import java.util.Set;

public class University {

    private String universityName;
    private Set<Faculty> faculties;



    public University(String universityName) {
        this.universityName = universityName;
    }



    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Set<Faculty> getFaculties() {
        if (faculties == null){
            faculties = new HashSet<>();
        }
        return faculties;
    }














//-------------------------------Вспомогательный метод для простоты вывода в консоль списка факультетов-----------------

}