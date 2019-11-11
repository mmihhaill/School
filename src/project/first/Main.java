package project.first;


import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        JFileChooser fileopen = new JFileChooser("resources");

        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            ReadFile readFile = new ReadFile(file);
            readFile.initializationClasses();
        }
    /*

    private static void showMainMenu() throws FileNotFoundException {
        System.out.println("1. Выбрать файл с классом - Введите 1");
        System.out.println("2. Выйти - Введите 2\n");
        System.out.print("Поле для ввода: ");

        Scanner in = new Scanner(System.in);
        School.mainMenu(in.nextInt());
    }

    private static void showClassMenu() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int options, numberClass;
        System.out.println("\n1. Выбрать класс - Введите 1");
        System.out.println("2. Выбрать другой файл со школой - Введите 2");
        System.out.println("3. Выйти - Введите 3\n");
        System.out.print("Поле для ввода: ");
        options = in.nextInt();

        switch (options) {
            case 1: {
                System.out.print("Введите порядковыфй номер номер класса: ");
                numberClass = in.nextInt();

                break;
            }
            case 2: {
                showMainMenu();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
        }*/
    }

}
