package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    // конструктор группы можно сразу настроить для добавления любого количества студентов
    private String title;
    List<Student> students = new ArrayList<>();

    public Group(String title) {
        this.title = title;
    }
    public void addStudent(Student... sts){
        Collections.addAll(students, sts);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
