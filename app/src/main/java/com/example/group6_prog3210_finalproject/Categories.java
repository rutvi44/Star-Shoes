package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class Categories extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutMenSubcategories, layoutWomenSubcategories, layoutKidsSubcategories;
    private Button btnMen, btnWomen, btnKids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Find views
        layoutMenSubcategories = findViewById(R.id.layout_men_subcategories);
        layoutWomenSubcategories = findViewById(R.id.layout_women_subcategories);
        layoutKidsSubcategories = findViewById(R.id.layout_kids_subcategories);
        btnMen = findViewById(R.id.btn_men);
        btnWomen = findViewById(R.id.btn_women);
        btnKids = findViewById(R.id.btn_kids);

        // Set click listeners
        btnMen.setOnClickListener(this);
        btnWomen.setOnClickListener(this);
        btnKids.setOnClickListener(this);

        // Find subtype buttons
        Button btnMenCasual = findViewById(R.id.btn_men_casual);
        Button btnMenDress = findViewById(R.id.btn_men_dress);
        Button btnMenBoots = findViewById(R.id.btn_men_boots);
        Button btnWomenFlats = findViewById(R.id.btn_women_flats);
        Button btnWomenHeels = findViewById(R.id.btn_women_heels);
        Button btnWomenWedges = findViewById(R.id.btn_women_wedges);
        Button btnKidsRainBoots = findViewById(R.id.btn_kids_rain_boots);
        Button btnKidsLightUp = findViewById(R.id.btn_kids_light_up);
        Button btnKidsDressShoes = findViewById(R.id.btn_kids_dress_shoes);
        Button btnKidsClogs = findViewById(R.id.btn_kids_clogs);

        // Set click listeners for subtype buttons
        btnMenCasual.setOnClickListener(this);
        btnMenDress.setOnClickListener(this);
        btnMenBoots.setOnClickListener(this);
        btnWomenFlats.setOnClickListener(this);
        btnWomenHeels.setOnClickListener(this);
        btnWomenWedges.setOnClickListener(this);
        btnKidsRainBoots.setOnClickListener(this);
        btnKidsLightUp.setOnClickListener(this);
        btnKidsDressShoes.setOnClickListener(this);
        btnKidsClogs.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();

        // Handle click for main category buttons
        if (id == R.id.btn_men) {
            toggleVisibility(layoutMenSubcategories);
        } else if (id == R.id.btn_women) {
            toggleVisibility(layoutWomenSubcategories);
        } else if (id == R.id.btn_kids) {
            toggleVisibility(layoutKidsSubcategories);
        }

        // Handle click for subcategory buttons
        else if (id == R.id.btn_men_casual) {
            // Handle click for men's casual category
            intent = new Intent(this, MenCasualShoes.class);
            startActivity(intent);
        } else if (id == R.id.btn_men_dress) {
            // Handle click for men's dress category
            intent = new Intent(this, MenDressShoes.class);
            startActivity(intent);
        } else if (id == R.id.btn_men_boots) {
            // Handle click for men's boots category
            intent = new Intent(this, MenBoot.class);
            startActivity(intent);
        } else if (id == R.id.btn_women_flats) {
            // Handle click for women's flats category
            intent = new Intent(this, WomenFlatShoes.class);
            startActivity(intent);
        } else if (id == R.id.btn_women_heels) {
            // Handle click for women's heels category
            intent = new Intent(this, WomenHeel.class);
            startActivity(intent);
        } else if (id == R.id.btn_women_wedges) {
            // Handle click for women's wedges category
            intent = new Intent(this, WomenWedges.class);
            startActivity(intent);
            // change all the home activity with actual activity
        } else if (id == R.id.btn_kids_rain_boots) {
            // Handle click for kids' rain boots category
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_kids_light_up) {
            // Handle click for kids' light-up shoes category
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_kids_dress_shoes) {
            // Handle click for kids' dress shoes category
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_kids_clogs) {
            // Handle click for kids' clogs category
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }





    private void toggleVisibility(LinearLayout layout) {
        if (layout.getVisibility() == View.VISIBLE) {
            layout.setVisibility(View.GONE);
        } else {
            layout.setVisibility(View.VISIBLE);
        }
    }
}