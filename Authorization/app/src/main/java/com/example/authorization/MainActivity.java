package com.example.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editLogin;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editLogin = findViewById(R.id.editTextTextEmailAddress);
        editPassword = findViewById(R.id.editTextTextPassword2);
        clearLoginPassword();
    }

    private void clearLoginPassword() {
        editLogin.getText().clear();
        editPassword.getText().clear();
    }

    public void doLogin(View view) {
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
            clearLoginPassword();
            Toast msgIncorrect = Toast.makeText(this, "Incorrect login or password", Toast.LENGTH_SHORT);
            msgIncorrect.show();
        }

    }

}