package com.mmihhaill.schools;

public class Main {
    public static void main(String[] args) {
        try {
            if(args[0].equals("-nameFile") && !args[1].equals("")){
                ReadFile readFile = new ReadFile(args[1]);
                readFile.dataLoading();
            }
            else errorInArgument();
        } catch (ArrayIndexOutOfBoundsException e) {
            errorInArgument();
            System.exit(0);
        }

        /*ReadFile readFile = new ReadFile("3");
        readFile.dataLoading();*/
    }

    static void errorInArgument() {
        System.out.println("аргумент не указан или указан неверно");
    }
}
