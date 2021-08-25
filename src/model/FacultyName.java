package model;

public enum FacultyName {
    MMF("Faculty Of Mechanic And Maths"),
    IRF("Faculty Of International Relations"),
    EFF("Faculty Of Economics And Finance"),
    HF("Historical Faculty");

    private String title;

    FacultyName(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
