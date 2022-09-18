package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doLogin(View view) {
        EditText editLogin = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText editPassword = (EditText) findViewById(R.id.editTextTextPassword2);

        String userEmail = editLogin.getText().toString();
        String userPassword = editPassword.getText().toString();

        String correctEmail = getResources().getString(R.string.correct_email);
        String correctPassword = getResources().getString(R.string.correct_password);

        if (userEmail.equals(correctEmail) && userPassword.equals(correctPassword)) {
            Log.d("Authorization", "Go to profile");
            Intent intentProfile = new Intent(this, ProfileActivity.class);
            startActivity(intentProfile);
        } else {
            Log.d("Authorization","login or password incorrect");
            Toast msgIncorrect = Toast.makeText(this, "Incorrect login or password", Toast.LENGTH_SHORT);
            msgIncorrect.show();
        }

    }

}