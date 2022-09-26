package com.example.authorization;

import androidx.annotation.Nullable;

public class Student extends User {

    private int course;
    private String groupName;
    private EducationInfo educationInfo;

    public Student(String name, String surname, String middleName, int course, String nameGroup, EducationInfo educationInfo) {
        super(name, surname, middleName);
        this.educationInfo = educationInfo;
        this.course = course;
        this.groupName = nameGroup;
    }

    public int getCourse() { return course; }

    public String getGroupName() { return groupName; }

    public String getFaculty() { return educationInfo.getFaculty(); }

    public String getSpecialty() { return educationInfo.getSpecialty(); }

    public String getEducationProgram() { return educationInfo.getEducationProgram(); }

    public String getEducationDegree() { return educationInfo.getEducationDegree(); }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }

        Student anotherStudent = (Student) obj;

        return anotherStudent.name.equals(name) && anotherStudent.surname.equals(surname) &&
                anotherStudent.middleName.equals(middleName) &&
                anotherStudent.educationInfo.equals(educationInfo);
    }

    @Override
    public String toString() {
        return super.toString() + groupName + ";" +  course + ";" + educationInfo.toString();
    }
}
