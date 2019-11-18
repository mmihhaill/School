package project.first;

import java.util.ArrayList;

public class StudentClass {
    private int classNumber;
    private String classLetter;
    private String classCurator;

    private ArrayList<Student> listStudents = new ArrayList<Student>();

    public StudentClass(int classNumber, String classLetter, String classCurator) {
        this.classNumber = classNumber;
        this.classLetter = classLetter;
        this.classCurator = classCurator;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassLetter() {
        return classLetter;
    }

    public void setClassLetter(String classLetter) {
        this.classLetter = classLetter;
    }

    public String getСlassCurator() {
        return classCurator;
    }

    public void setСlassCurator(String classCurator) {
        this.classCurator = classCurator;
    }

    public void setStudents(String name) {
        listStudents.add(new Student(name));
    }

    @Override
    public String toString() {

        return classNumber + "-" + classLetter + " Куратор: " + classCurator;
    }
    public void showStudent() {
        for(Student student : listStudents){
            System.out.println(listStudents.indexOf(student) + ": " + student.toString());
        }
    }
}
