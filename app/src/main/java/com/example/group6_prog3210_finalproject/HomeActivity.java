package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Button btnHome = findViewById(R.id.buttonHome);
//
//        btnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, ActivityAbout.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            Intent home = new Intent(this, HomeActivity.class);
            startActivity(home);
        } else if (itemId == R.id.nav_about) {
            Intent about = new Intent(this, ActivityAbout.class);
            startActivity(about);
            return true;
        } else if (itemId == R.id.nav_men_boots) {
            Intent about = new Intent(this, MenBoot.class);
            startActivity(about);
            return true;
        } else if (itemId == R.id.nav_men_dress) {
            Intent tvs = new Intent(this, MenDressShoes.class);
            startActivity(tvs);
            return true;
        } else if (itemId == R.id.nav_men_casual) {
            Intent computers = new Intent(this, MenCasualShoes.class);
            startActivity(computers);
            return true;
        }
        else if (itemId == R.id.nav_Women_flats) {
        Intent computers = new Intent(this, WomenFlatShoes.class);
        startActivity(computers);
        return true;
        } else if (itemId==R.id.nav_Women_heels) {
        Intent computers = new Intent(this, WomenHeel.class);
        startActivity(computers);
        return true;
        } else if (itemId==R.id.nav_Women_wedges) {
        Intent computers = new Intent(this, WomenWedges.class);
        startActivity(computers);
        return true;
        } else if (itemId==R.id.nav_store_locator) {
        Intent computers = new Intent(this, StoreLocation.class);
        startActivity(computers);
        return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
