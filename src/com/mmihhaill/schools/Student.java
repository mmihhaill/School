package com.mmihhaill.schools;

public class Student {
    private String fioStudent;

    public Student(String fioStudent) {
        this.fioStudent = fioStudent;
    }

    public String getFioStudent() {
        return fioStudent;
    }

    @Override
    public String toString() {
        return "ФИО = " + fioStudent;
    }
}
