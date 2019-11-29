package com.mmihhaill.schools;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectMenu {
    private ArrayList<School> listObjectsSchool = new ArrayList<School>();
    private Scanner in;
    private int numberCheckSchool;

    private void schoolMenu() {
        in = new Scanner(System.in);
        System.out.println("\n1. Вывести классы определенной школы - Введите 1");
        System.out.println("2. Выйти - Введите 2\n");
        System.out.print("Поле для ввода: ");
        try {
            switch (in.nextByte()) {
                case 1:
                    showClasses();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    schoolMenu();
            }
        } catch (Exception e) {
            schoolMenu();
        }
    }

    private void classMenu() {
        in = new Scanner(System.in);
        System.out.println("\n1. Вывести учеников определенного класса - Введите 1");
        System.out.println("2. Назад - Введите 2");
        System.out.println("3. Выйти - Введите 3\n");
        System.out.print("Поле для ввода: ");
        try {
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
                default:
                    classMenu();
            }
        } catch (Exception e) {
            classMenu();
        }
    }

    private void studentMenu() {
        in = new Scanner(System.in);
        System.out.println("\n1. В главное меню - Введите 1");
        System.out.println("2. Выйти - Введите 2\n");
        System.out.print("Поле для ввода: ");
        try {
            switch (in.nextByte()) {
                case 1:
                    showSchools();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    studentMenu();
            }
        } catch (Exception e) {
            studentMenu();
        }
    }

    void showSchools() {
        System.out.println("\nСписок школ:");
        for (School school : listObjectsSchool) {
            System.out.println("Школа " + listObjectsSchool.indexOf(school)
                    + ": " + school.getSchoolName());
        }
        schoolMenu();
    }

    private void showClasses() {
        in = new Scanner(System.in);
        System.out.print("Введите порядковый номер школы: ");
        try {
            numberCheckSchool = in.nextInt();
        } catch (Exception e) {
            showClasses();
        }
        listObjectsSchool.get(numberCheckSchool).showClasses();
        classMenu();
    }

    private void showStudent() {
        in = new Scanner(System.in);
        System.out.print("Введите порядковый номер класса: ");
        try {
            listObjectsSchool.get(numberCheckSchool).getListStudentsClass()
                    .get(in.nextInt()).showStudent();
        } catch (Exception e) {
            showStudent();
        }
        studentMenu();
    }
    private void filterCollections(){
        listObjectsSchool.stream().filter(line -> line.equals("f")).forEach(System.out::println);
    }
}
