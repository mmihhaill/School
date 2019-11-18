package project.first;

public class Student {
    private String fioStudent;

    public Student(String fioStudent) {
        this.fioStudent = fioStudent;
    }

    public String getFioStudent() {
        return fioStudent;
    }

    public void setFioStudent(String fioStudent) {
        this.fioStudent = fioStudent;
    }

    @Override
    public String toString() {
        return "ФИО = " + fioStudent;
    }
}
