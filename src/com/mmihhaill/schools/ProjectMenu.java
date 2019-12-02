package com.mmihhaill.schools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProjectMenu {
    private List<School> listObjectsSchool = new ArrayList<School>();

    private Scanner in;
    private int numberCheckSchool, numberCheckClass;

    private void schoolMenu() {
        in = new Scanner(System.in);
        System.out.println("\n1. Вывести классы определенной школы");
        System.out.println("2. Выйти\n");
        System.out.print("--> ");
        try {
            switch (in.nextByte()) {
                case 1: {
                    showClasses();
                    break;
                }
                case 2: {
                    System.exit(0);
                    break;
                }
                default: {
                    schoolMenu();
                }
            }
        } catch (Exception e) {
            schoolMenu();
        }
    }

    private void classMenu() {
        in = new Scanner(System.in);
        System.out.println("\n1. Вывести учеников определенного класса");
        System.out.println("2. Назад");
        System.out.println("3. Выйти\n");
        System.out.print("--> ");
        try {
            switch (in.nextByte()) {
                case 1: {
                    showStudent();
                    break;
                }
                case 2: {
                    showSchools();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    classMenu();
                }
            }
        } catch (Exception e) {
            classMenu();
        }
    }

    private void studentMenu() {
        in = new Scanner(System.in);
        System.out.println("\n1. В главное меню");
        System.out.println("2. Фильтр");
        System.out.println("3. Выйти\n");
        System.out.print("--> ");
        try {
            switch (in.nextByte()) {
                case 1: {
                    showSchools();
                    break;
                }
                case 2: {
                    filter();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    studentMenu();
                }
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
        System.out.print("Порядковый номер школы --> ");
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
        System.out.print("Порядковый номер класса --> ");
        try {
            numberCheckClass = in.nextInt();
            listObjectsSchool.get(numberCheckSchool).getListStudentsClass()
                    .get(numberCheckClass).showStudent();
        } catch (Exception e) {
            showStudent();
        }
        studentMenu();
    }

    private void filter() {
        System.out.print("Параметр фильтрации --> ");
        listObjectsSchool.get(numberCheckSchool).getListStudentsClass()
                .get(numberCheckClass).filterCollectionsStudents(in.next());
    studentMenu();
    }
}
