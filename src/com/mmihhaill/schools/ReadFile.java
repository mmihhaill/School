package com.mmihhaill.schools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ReadFile {

    private String nameArgumentFile;
    private File fileSchool;

    public ReadFile(String nameArgumentFile) {
        this.nameArgumentFile = nameArgumentFile;
    }

    void dataLoading() {
        final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        fileSchool = new File("resources", nameArgumentFile + ".json");
        if (fileSchool.isFile()) {
            try {
                FileReader reader = new FileReader(fileSchool);
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);
                ProjectMenu projectMenu = GSON.fromJson(jsonObject, ProjectMenu.class);
                projectMenu.showSchools();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("такого файла не существует");
        }
    }
}