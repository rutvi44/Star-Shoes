package com.example.group6_prog3210_finalproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPassword, editTextRePassword;
    private DBHandler dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dbHelper = new DBHandler(this);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextemail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRePassword = findViewById(R.id.editTextRePassword);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        findViewById(R.id.textViewHaveAcc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Forgot Password Recovery
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        });
    }

    private void signUp() {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String rePassword = editTextRePassword.getText().toString();

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Invalid email address (example@eg.com)", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(rePassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidPassword(password)) {
            Toast.makeText(this, "Password must contain at least one uppercase letter, one number, and one special character", Toast.LENGTH_SHORT).show();
            return;
        }
        // Insert new user data into database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHandler.COLUMN_NAME, name);
        values.put(DBHandler.COLUMN_EMAIL, email);
        values.put(DBHandler.COLUMN_PASSWORD, password);

        long newRowId = db.insert(DBHandler.TABLE_USERS, null, values);
        if (newRowId == -1) {
            Toast.makeText(this, "Error with saving user", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "User saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
        }

    }



    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
