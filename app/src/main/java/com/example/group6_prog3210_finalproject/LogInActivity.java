package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextemail);
        editTextPassword = findViewById(R.id.editTextPassword);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }


        });

        findViewById(R.id.textView6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Password Recovery Activity
                startActivity(new Intent(LogInActivity.this, HomeActivity.class));
            }
        });

        // Example handlers for social media login buttons
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Facebook Login
            }
        });

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Google Login
                // Redirect to SignupActivity when Google login layout is clicked
                startActivity(new Intent(LogInActivity.this, SignUpActivity.class));
            }
        });
    }

    private void login() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Invalid email format (example@eg.com)", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidPassword(password)) {
            Toast.makeText(this, "Password must contain at least one uppercase letter, one number, and one special character", Toast.LENGTH_SHORT).show();
            return;
        }

        // Proceed with actual login logic here (e.g., API call)

        // If validation is successful, proceed to the About activity
        startActivity(new Intent(LogInActivity.this, ActivityAbout.class));
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }

}
