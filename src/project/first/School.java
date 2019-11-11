package project.first;

import java.util.ArrayList;;

public class School {
    private String schoolName;

    private ArrayList<StudentClass> listStudentsClass = new ArrayList<StudentClass>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String[] separationCLass(String nameClass) {
        return nameClass.split("_");
    }

    public void setStudentsClass(StudentClass studentClass) {
        listStudentsClass.add(studentClass);
    }


}
