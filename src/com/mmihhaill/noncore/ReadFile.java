package com.mmihhaill.noncore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private String nameArgumentFile;

    private Scanner scanFile;
    private ArrayList<String> listClass = new ArrayList<String>();
    private ArrayList<String> listCurator = new ArrayList<String>();
    private ArrayList<School> listObjectsSchool = new ArrayList<School>();
    //private JFileChooser fileopen = new JFileChooser("resources");
    private Scanner in = new Scanner(System.in);
    private int numberCheckSchool;

    public ReadFile(String nameArgumentFile) {
        this.nameArgumentFile = nameArgumentFile;
    }

    public void mainMenu() {
        dataLoading();
        /*
        System.out.println("1. Выбрать файл - Введите 1");
        System.out.println("2. Выйти - Введите 2\n");
        System.out.print("Поле для ввода: ");
        switch (in.nextByte()) {
            case 1:
                dataLoading();
                showSchools();
                break;
            case 2:
                System.exit(0);
                break;
        }*/
    }
    private void schoolMenu() {
        System.out.println("\n1. Вывести классы определенной школы - Введите 1");
        //System.out.println("2. В главное меню - Введите 2");
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
        //System.out.println("3. В главное меню - Введите 3");
        System.out.println("3. Выйти - Введите 3\n");
        System.out.print("Поле для ввода: ");

        switch (in.nextByte()) {
            case 1:
                showStudent();
                break;
            case 2:
                mainMenu();
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
                mainMenu();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
    //methods for withdrawing schools, classes, students
    private void showSchools(){
        System.out.println("Список школ:");
        for(School school : listObjectsSchool){
            System.out.println("Школа " + listObjectsSchool.indexOf(school) + ": " + school.getSchoolName());
        }
        schoolMenu();
    }
    private void showClasses(){
        System.out.print("Введите порядковый номер школы: ");
        numberCheckSchool = in.nextInt();
        listObjectsSchool.get(numberCheckSchool).showClasses();
        classMenu();
    }
    private void showStudent(){
        System.out.print("Введите порядковый номер класса: ");
        listObjectsSchool.get(numberCheckSchool).getListStudentsClass().get(in.nextInt()).showStudent();
        studentMenu();
    }
    private void clearAllList(){
        listClass.clear();
        listObjectsSchool.clear();
        listCurator.clear();
    }
    //loading information from a file
    private void dataLoading() {
        clearAllList();
        File fileSchool = new File("resources", nameArgumentFile +".txt");
        if(fileSchool.isFile()){
            try {
                scanFile = new Scanner(fileSchool);
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
            String fileString;
            String[] strMass = new String[3];
            while (scanFile.hasNextLine()) {
                fileString = scanFile.nextLine();

                if (fileString.equals("school")) {
                    while (!(fileString = scanFile.nextLine()).equals("/school"))
                        listObjectsSchool.add(new School(fileString));
                } else if (fileString.equals("class")) {
                    while (!(fileString = scanFile.nextLine()).equals("/class"))
                        listClass.add(fileString);
                } else if (fileString.equals("curator")) {
                    while (!(fileString = scanFile.nextLine()).equals("/curator"))
                        listCurator.add(fileString);
                } else if (fileString.equals("connectionKurator")) {
                    while (!(fileString = scanFile.nextLine()).equals("/connectionKurator")) {
                        strMass = fileString.split("-");
                        listObjectsSchool.get(Integer.parseInt(fileString.split("-")[0])).setStudentsClass(
                                (listClass.get(Integer.parseInt(fileString.split("-")[1]))).split("-")[1],
                                listCurator.get(Integer.parseInt(fileString.split("-")[2])),
                                Integer.parseInt((listClass.get(Integer.parseInt(fileString.split("-")[1]))).split("-")[0]));
                    }
                } else if (fileString.equals("student")) {
                    while (!(fileString = scanFile.nextLine()).equals("/student")) {
                        strMass = fileString.split("-");
                        listObjectsSchool.get(Integer.parseInt(fileString.split("-")[0])).getListStudentsClass().get(Integer.parseInt(fileString.split("-")[1])).setStudents(fileString.split("-")[2]);
                    }
                }
            }
            showSchools();
        }
        else{
            System.out.println("такого файла не существует");
        }
        /*int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File informationFile = fileopen.getSelectedFile();

        }*/
    }
}