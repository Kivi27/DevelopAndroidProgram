package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EducationInfo testEducationInfo = new EducationInfo("Бакалавр","Факультет інформаційних " +
                "технологій і систем", "122 - Комп'ютерні науки", "Комп’ютерні " +
                "науки та прикладне програмування");
        Student testStudent = new Student("Ростислав", "Ляшенко", "Іванович",
                3, "КНС-2201", testEducationInfo);

        TextView txtFullName = (TextView) findViewById(R.id.textNameSurname);
        txtFullName.setText(testStudent.getFullName());

        TextView txtGroupName = (TextView) findViewById(R.id.textGroup);
        txtGroupName.setText(testStudent.getGroupName());

        TextView txtCourse = (TextView) findViewById(R.id.textCourse);
        txtCourse.setText(Integer.toString(testStudent.getCourse()));

        TextView txtEducationDegree = (TextView) findViewById(R.id.textEducationDegree);
        txtEducationDegree.setText(testStudent.getEducationDegree());

        TextView txtFaculty = (TextView) findViewById(R.id.textFaculty);
        txtFaculty.setText(testStudent.getFaculty());

        TextView txtSpecialty = (TextView) findViewById(R.id.textSpecialty);
        txtSpecialty.setText(testStudent.getSpecialty());

        TextView txtEducationProgram = (TextView) findViewById(R.id.textEducationProgram);
        txtEducationProgram.setText(testStudent.getEducationProgram());

    }

    public void exitToLoginPage(View view) {
        finish();
    }
}