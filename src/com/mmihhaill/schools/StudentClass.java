package com.mmihhaill.schools;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentClass {
    private String classNumber;
    private String classLetter;
    private String classCurator;

    private List<Student> listStudents = new ArrayList<Student>();
    private List<Student> spareListStudents = new ArrayList<Student>(listStudents);

    public StudentClass(String classNumber, String classLetter, String classCurator) {
        this.classNumber = classNumber;
        this.classLetter = classLetter;
        this.classCurator = classCurator;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getClassLetter() {
        return classLetter;
    }

    @Override
    public String toString() {

        return classNumber + "-" + classLetter + " Куратор: " + classCurator;
    }

    public void showStudent() {
        for (Student student : listStudents) {
            System.out.println(listStudents.indexOf(student) + ": " + student.toString());
        }
    }

    void filterCollectionsStudents(String parameter) {
        spareListStudents = listStudents.stream()
                .filter(line -> line.getFioStudent().contains(parameter))
                .collect(Collectors.toList());
        for (Student student : spareListStudents) {
            System.out.println(spareListStudents.indexOf(student) + ": " + student.toString());
        }
    }
}
