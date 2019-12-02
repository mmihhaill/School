package com.mmihhaill.schools;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String schoolName;

    private List<StudentClass> listStudentsClass = new ArrayList<StudentClass>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public List<StudentClass> getListStudentsClass() {
        return listStudentsClass;
    }
    public void showClasses() {
        for (StudentClass studentClass : listStudentsClass) {
            System.out.println("Класс " + listStudentsClass.indexOf(studentClass) + ": " + studentClass.toString());
        }
    }
}