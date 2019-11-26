package com.mmihhaill.schools;

import java.util.ArrayList;;

public class School {
    private String schoolName;

    private ArrayList<StudentClass> listStudentsClass = new ArrayList<StudentClass>();


    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setStudentsClass(String classLetter, String classCurator, int classNumber) {
        listStudentsClass.add(new StudentClass(classNumber, classLetter, classCurator));
    }

    public ArrayList<StudentClass> getListStudentsClass() {
        return listStudentsClass;
    }

    public void setListStudentsClass(ArrayList<StudentClass> listStudentsClass) {
        this.listStudentsClass = listStudentsClass;
    }

    public void showClasses() {
        for(StudentClass studentClass : listStudentsClass){
            System.out.println("Класс " + listStudentsClass.indexOf(studentClass) + ": " + studentClass.toString());
        }
    }

}