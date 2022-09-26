package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private void getAllTextView(View v, List<TextView> allTextView) {
        String plug = getResources().getString(R.string.plug);
        ViewGroup viewgroup = (ViewGroup) v;
        for (int i = 0;i < viewgroup.getChildCount(); i++) {
            View v1 = viewgroup.getChildAt(i);
            if (v1 instanceof TextView && ((TextView) v1).getText().equals(plug)) {
                TextView curTextView = (TextView) v1;
                allTextView.add(curTextView);
            }
            if (v1 instanceof ViewGroup) {
                getAllTextView(v1, allTextView);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EducationInfo testEducationInfo = new EducationInfo("Бакалавр","Факультет інформаційних " +
                "технологій і систем", "122 - Комп'ютерні науки", "Комп’ютерні " +
                "науки та прикладне програмування");
        Student testStudent = new Student("Ростислав", "Ляшенко", "Іванович",
                3, "КНС-2201", testEducationInfo);

        List<TextView> allTextView = new ArrayList<>();
        getAllTextView(getWindow().getDecorView(), allTextView);

        String[] infoAboutStudent = testStudent.toString().split(";");
        for (int i = 0; i < infoAboutStudent.length; i++) {
            TextView curTextView = allTextView.get(i);
            curTextView.setText(infoAboutStudent[i]);
        }
    }

    public void exitToLoginPage(View view) {
        Intent intentLogin = new Intent(this, MainActivity.class);
        startActivity(intentLogin);
    }
}