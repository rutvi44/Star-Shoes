package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StoreRating extends AppCompatActivity {

    private EditText etFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_rating);// Find the ImageView button by its ID
        ImageView btnBack = findViewById(R.id.btnBack);
        Button btnSubmit = findViewById(R.id.btn_submit);
        etFeedback = findViewById(R.id.et_feedback);

        // Set an OnClickListener for the button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the desired activity
                Intent intent = new Intent(StoreRating.this, HomeActivity.class);
                startActivity(intent);
            }
        });

            // Set OnClickListener for the submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform submission logic
                submitFeedback();
            }
        });
    }

    // Method to handle feedback submission
    private void submitFeedback() {
        // Get the text from the EditText
        String feedback = etFeedback.getText().toString().trim();

        // Check if feedback is empty
        if (!feedback.isEmpty()) {
            // Show a toast message indicating successful submission
            Toast.makeText(StoreRating.this, "Thank you for your response. Feedback submitted successfully.", Toast.LENGTH_SHORT).show();

            // Clear the EditText
            etFeedback.setText("");
        } else {
            // Show a toast message indicating that feedback is required
            Toast.makeText(StoreRating.this, "Please enter your feedback.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}