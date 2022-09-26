package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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

    }

    public void exitToLoginPage(View view) {
        finish();
    }
}