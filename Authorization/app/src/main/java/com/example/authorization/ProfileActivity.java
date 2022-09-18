package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private void showChildren(View v, List<TextView> allTextView) {
        ViewGroup viewgroup = (ViewGroup) v;
        for (int i = 0;i < viewgroup.getChildCount(); i++) {
            View v1 = viewgroup.getChildAt(i);
            if (v1 instanceof TextView) {
                TextView curTextView = (TextView) v1;
                allTextView.add(curTextView);
            }
            if (v1 instanceof ViewGroup) {
                showChildren(v1, allTextView);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        InformEducation testInformEducation = new InformEducation("Бакалавр","Факультет інформаційних " +
                "технологій і систем", "122 - Комп'ютерні науки", "Комп’ютерні " +
                "науки та прикладне програмування");
        Student testStudent = new Student("Rostyslav", "Liashenko", "Ivanovich",
                3, "КНС-2201", testInformEducation);

        List<TextView> allTextView = new ArrayList<>();
        showChildren(getWindow().getDecorView(), allTextView);

        for (int i = 0; i < allTextView.size(); i++) {
            TextView curTextView = allTextView.get(i);
            curTextView.setText("TextView_" + i);
        }

    }
}