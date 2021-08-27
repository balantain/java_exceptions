package model;

import exceptions.NoDisciplineException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;

    List<Discipline> schedule;
    Map<Discipline, Integer> dairy = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//--------------------------------------------------------------------
    public List<Discipline> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Discipline> schedule) {
        this.schedule = schedule;
    }
//--------------------------------------------------------------------

    public void setMarkForDiscipline(Discipline discipline, Integer mark) throws NoDisciplineException {
        if (schedule.contains(discipline)){
            dairy.put(discipline, mark);
        }
        else {
            throw new NoDisciplineException("There are no such discipline in " + name + " dairy");
        }
    }

    @Override
    public String toString() {
        return name;
    }

//------------------------------------------- Пока не нужно ---------------------------------------------
//    private Group group;
//    public Student(String name, Group group) {
//        this.name = name;
//        this.group = group;
//    }
//    public Group getGroup() {
//        return group;
//    }
//
//    public void setGroup(Group group) {
//        this.group = group;
//    }
}
