package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAbout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Find the ImageView button by its ID
        ImageView btnBack = findViewById(R.id.btnBack);

        // Set an OnClickListener for the button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the desired activity
                Intent intent = new Intent(ActivityAbout.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
