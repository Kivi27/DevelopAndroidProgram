package com.example.authorization;

import androidx.annotation.Nullable;

public class Student extends User {

    private int course;
    private String nameGroup;
    private InformEducation informEducation;

    public Student(String name, String surname, String middleName, int course, String nameGroup, InformEducation informEducation) {
        super(name, surname, middleName);
        this.informEducation = informEducation;
        this.course = course;
        this.nameGroup = nameGroup;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }

        Student anotherStudent = (Student) obj;

        return anotherStudent.name.equals(name) && anotherStudent.surname.equals(surname) &&
                anotherStudent.middleName.equals(middleName) &&
                anotherStudent.informEducation.equals(informEducation);
    }

    @Override
    public String toString() {
        return super.toString() + nameGroup + ";" +  course + ";" + informEducation.toString();
    }

}
