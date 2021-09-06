package model;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<Discipline, Integer> dairy;



    public Student(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Discipline, Integer> getDairy() {
        if (dairy == null){
            dairy = new HashMap<>();
        }
        return dairy;
    }

    public void setDairy(Map<Discipline, Integer> dairy) {
        this.dairy = dairy;
    }
}
