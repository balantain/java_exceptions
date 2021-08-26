package model;

public class Student {
    private String name;
    private Group group; // для того, чтобы студента при создании можно было сразу добавлять в группу.
    private Dairy dairy;// дневник успеваемости

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

    public Dairy getDairy() {
        return dairy;
    }

    public void setDairy(Dairy dairy) {
        this.dairy = dairy;
    }

    // обязательно toString
}
