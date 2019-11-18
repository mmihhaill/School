package project.first;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private Scanner scanFile;
    private ArrayList<String> listClass = new ArrayList<String>();
    private ArrayList<String> listCurator = new ArrayList<String>();
    private ArrayList<School> listObjectsSchool = new ArrayList<School>();
    private JFileChooser fileopen = new JFileChooser("resources");
    private Scanner in = new Scanner(System.in);
    private int numberCheckSchool;

    public void mainMenu() {
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
        }
    }
    void schoolMenu() {
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
    void classMenu() {
        System.out.println("\n1. Вывести учеников определенного класса - Введите 1");
        System.out.println("2. Выйти - Введите 2\n");
        System.out.print("Поле для ввода: ");

        switch (in.nextByte()) {
            case 1:
                showStudent();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
    void studentMenu() {
        System.out.println("\n1. Вернуться в начало - Введите 1");
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
    void showSchools(){
        System.out.println("Список школ:");
        for(School school : listObjectsSchool){
            System.out.println("Школа " + listObjectsSchool.indexOf(school) + ": " + school.getSchoolName());
        }
        schoolMenu();
    }
    void showClasses(){
        System.out.print("Введите порядковый номер школы: ");
        numberCheckSchool = in.nextInt();
        listObjectsSchool.get(numberCheckSchool).showClasses();
        classMenu();
    }
    void showStudent(){
        System.out.print("Введите порядковый номер класса: ");
        listObjectsSchool.get(numberCheckSchool).getListStudentsClass().get(in.nextInt()).showStudent();
        studentMenu();
    }
    void clearAllList(){
        listClass.clear();
        listObjectsSchool.clear();
        listCurator.clear();
    }
    //loading information from a file
    void dataLoading() {
        clearAllList();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File informationFile = fileopen.getSelectedFile();
            try {
                scanFile = new Scanner(informationFile);
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
        }
    }
}