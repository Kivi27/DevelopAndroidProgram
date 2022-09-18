package com.example.authorization;

import androidx.annotation.Nullable;

public class InformEducation {

    private String faculty;
    private String specialty;
    private String educationProgram;

    public InformEducation(String faculty, String specialty, String educationProgram) {
        this.faculty = faculty;
        this.specialty = specialty;
        this.educationProgram = educationProgram;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getEducationProgram() {
        return educationProgram;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof InformEducation)) {
            return false;
        }

        InformEducation otherInformEdu = (InformEducation) obj;
        return otherInformEdu.faculty.equals(faculty) &&
                otherInformEdu.specialty.equals(specialty) &&
                otherInformEdu.educationProgram.equals(educationProgram);
    }
}
