package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private DBHandler dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextemail);
        editTextPassword = findViewById(R.id.editTextPassword);

        // Initialize the database helper object
        dbHelper = new DBHandler(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }


        });

        findViewById(R.id.textViewSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Forgot Password Recovery
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
        // Check if the user exists in the database
        if (checkUser(email, password)) {
            // If validation is successful, proceed to the About activity
            startActivity(new Intent(LogInActivity.this, ActivityAbout.class));
        } else {
            Toast.makeText(this, "Invalid login credentials or user not registered", Toast.LENGTH_LONG).show();
        }

    }

    // Check if user exists in the database
    private boolean checkUser(String email, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {DBHandler.COLUMN_ID};
        String selection = DBHandler.COLUMN_EMAIL + "=? AND " + DBHandler.COLUMN_PASSWORD + "=?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(DBHandler.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;

    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }

}
