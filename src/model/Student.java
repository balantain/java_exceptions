package model;

import exceptions.NoDisciplineException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private Group group; // для того, чтобы студента при создании можно было сразу добавлять в группу.
    List<Discipline> schedule;
    Map<Discipline, Integer> dairy = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setMarkForDiscipline(Discipline discipline, Integer mark) throws NoDisciplineException {
        if (schedule.contains(discipline)){
            dairy.put(discipline, mark);
        }
        else {
            throw new NoDisciplineException("There are no such discipline in " + name + " dairy");
        }
    }
}
