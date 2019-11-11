package project.first;

public class Student {
    private String fioStudent;
    private int ageStudent;

    public Student(String fioStudent, int ageStudent) {
        this.fioStudent = fioStudent;
        this.ageStudent = ageStudent;
    }

    public String getFioStudent() {
        return fioStudent;
    }

    public void setFioStudent(String fioStudent) {
        this.fioStudent = fioStudent;
    }

    public int getAgeStudent() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent = ageStudent;
    }

    @Override
    public String toString() {
        return "ФИО = " + fioStudent + ", Возраст = " + ageStudent;
    }
}
