package com.example.authorization;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EducationInfo {

    private String faculty;
    private String specialty;
    private String educationProgram;
    private String educationDegree;

    public EducationInfo(String educationDegree, String faculty, String specialty, String educationProgram) {
        this.educationDegree = educationDegree;
        this.faculty = faculty;
        this.specialty = specialty;
        this.educationProgram = educationProgram;
    }

    public String getFaculty() { return faculty; }

    public String getSpecialty() { return specialty; }

    public String getEducationProgram() { return educationProgram; }

    public String getEducationDegree() { return educationDegree; }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof EducationInfo)) {
            return false;
        }

        EducationInfo otherInformEdu = (EducationInfo) obj;
        return otherInformEdu.faculty.equals(faculty) &&
                otherInformEdu.specialty.equals(specialty) &&
                otherInformEdu.educationProgram.equals(educationProgram);
    }

    @NonNull
    @Override
    public String toString() {
        return educationDegree + ";" + faculty + ";" + specialty + ";" + educationProgram;
    }
}
