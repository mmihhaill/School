package com.mmihhaill.schools;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectMenu {
    private ArrayList<School> listObjectsSchool = new ArrayList<School>();
    private Scanner in = new Scanner(System.in);
    private int numberCheckSchool;

    private void schoolMenu() {
        System.out.println("\n1. Вывести классы определенной школы - Введите 1");
        System.out.println("2. Выйти - Введите 2\n");
        System.out.print("Поле для ввода: ");

        switch (in.nextByte()) {
            case 1:
                showClasses();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    private void classMenu() {
        System.out.println("\n1. Вывести учеников определенного класса - Введите 1");
        System.out.println("2. Назад - Введите 2");
        System.out.println("3. Выйти - Введите 3\n");
        System.out.print("Поле для ввода: ");

        switch (in.nextByte()) {
            case 1:
                showStudent();
                break;
            case 2:
                showSchools();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    private void studentMenu() {
        System.out.println("\n1. В главное меню - Введите 1");
        System.out.println("2. Выйти - Введите 2\n");
        System.out.print("Поле для ввода: ");

        switch (in.nextByte()) {
            case 1:
                showSchools();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    void showSchools() {

        System.out.println("\n\nСписок школ:");
        for (School school : listObjectsSchool) {
            System.out.println("Школа " + listObjectsSchool.indexOf(school) + ": " + school.getSchoolName());
        }
        schoolMenu();
    }

    private void showClasses() {
        System.out.print("Введите порядковый номер школы: ");
        numberCheckSchool = in.nextInt();
        listObjectsSchool.get(numberCheckSchool).showClasses();
        classMenu();
    }

    private void showStudent() {
        System.out.print("Введите порядковый номер класса: ");
        listObjectsSchool.get(numberCheckSchool).getListStudentsClass().get(in.nextInt()).showStudent();
        studentMenu();
    }
}
