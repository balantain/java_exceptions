package model;

import exceptions.MarkValueException;
import exceptions.NoDisciplineException;

import java.util.*;

public class Student {
    private String name;
    private Faculty faculty;
    private Group group;
    private List<Discipline> schedule = new ArrayList<>();
    private Map<Discipline, Integer> dairy = new HashMap<>();
//--------------- Конструкторы:
    public Student(String name) {
        this.name = name;
    }

//--------------- Геттеры и сеттеры:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Map<Discipline, Integer> getDairy() {
        return dairy;
    }

    public void setDairy(Map<Discipline, Integer> dairy) {
        this.dairy = dairy;
    }

    public List<Discipline> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Discipline> schedule) {
        this.schedule = schedule;
    }
//---------- Для красоты выводим список дисциплин студента в виде строки (для себя)------------------------------------

    public String getScheduleAsString(List<Discipline> schedule){
        StringBuilder scheduleAsString = new StringBuilder("| ");
        for (Discipline discipline : schedule){
            scheduleAsString.append(discipline.getTitle()).append(" | ");
        }
        return scheduleAsString.toString();
    }
    public String getDairyAsString(Map<Discipline, Integer> dairy){
        StringBuilder dairyAsString = new StringBuilder("| ");
        for (Map.Entry<Discipline, Integer> entry : dairy.entrySet()){
            dairyAsString.append(entry.getKey().getTitle()).append(" - ").append(entry.getValue()).append(" | ");
        }
        return dairyAsString.toString();
    }

//-------------------------------------------- Ставим случайную оценку по предмету (для проверки кода ------------------

    public void setMarkForDiscipline(Discipline discipline, Integer mark) throws NoDisciplineException, MarkValueException {
        if (schedule.contains(discipline) || !schedule.isEmpty()){
            if (mark <= 0 || mark > 10){
                throw new MarkValueException("Mark value is not in diapason from 1 to 10");
            }
            else {
                dairy.put(discipline, mark);
            }
        }
        else {
            throw new NoDisciplineException("There are no such discipline in " + name + " dairy");
        }
    }
//-------------------------------------------- Заполняем дневник рандомными оценками------------------------------------
    public void setRandomMarksToDairy() throws NoDisciplineException, MarkValueException {
        Random random = new Random();
        for (Discipline discipline : schedule){
            setMarkForDiscipline(discipline, (random.nextInt(10) + 1));
        }
    }


    @Override
    public String toString() {
        return "Student: |" + name + "|";
    }

    public String toStringWithDairy() {
        return "Student: |" + name + "| - " +
                "Dairy: " + getDairyAsString(dairy);
    }
    public String toStringWithSchedule() {
        return "Student: |" + name + "| - " + "Disciplines: " + getScheduleAsString(schedule);
    }
}
