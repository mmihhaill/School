package com.mmihhaill.core;


import com.mmihhaill.noncore.ReadFile;

public class Main {
    public static void main(String[] args) {
        try {
            if(args[0].equals("-nameFile") && !args[1].equals("")){
                ReadFile readFile = new ReadFile(args[1]);
                readFile.mainMenu();
            }
            else errorInArgument();
        } catch (ArrayIndexOutOfBoundsException e) {
            errorInArgument();
            System.exit(0);
        }
    }

    static void errorInArgument() {
        System.out.println("аргумент не указан или указан неверно");
    }
}
