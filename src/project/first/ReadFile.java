package project.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private File informationFile;
    private Scanner scanFile;
    private ArrayList<School> listSchool = new ArrayList<School>();

    ReadFile(File informationFile) {
        this.informationFile = informationFile;
    }

    void initializationClasses() {
        try {
            scanFile = new Scanner(informationFile);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        String fileString;
        while (scanFile.hasNextLine()) {
            fileString = scanFile.nextLine();

            if (fileString.equals("school")) {
                while (!(fileString = scanFile.nextLine()).equals("/school"))
                    listSchool.add(new School(fileString));
            }
        }
        for (School sch : listSchool) {
            System.out.println(sch.getSchoolName());
        }
    }
}