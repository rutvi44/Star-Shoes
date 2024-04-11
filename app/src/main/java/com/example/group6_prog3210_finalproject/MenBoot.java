package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenBoot extends AppCompatActivity {
    private CheckBox cbComp1,cbComp2,cbComp3;
    private Button btnAdd,btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensboots);
        cbComp1=findViewById(R.id.cbComp1);
        cbComp2=findViewById(R.id.cbComp2);
        cbComp3=findViewById(R.id.cbComp3);
       // btnCheckout=findViewById(R.id.checkout_button);
        btnAdd=findViewById(R.id.btnAdd);
//        btnCheckout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addToView();
//                Intent checkoutIntent= new Intent(getApplicationContext(),Checkout.class);
//                startActivity(checkoutIntent);
//            }
//        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToView();
            }
        });
    }
    public void addToView(){
        SharedPreferences myPreference =
                getSharedPreferences("info", MODE_PRIVATE);
        //prepare it for edit by creating an Edit object
        SharedPreferences.Editor prefEditor = myPreference.edit();

        //checking and saving info from checkboxes
        boolean app1Checked = cbComp1.isChecked();
        boolean app2Checked = cbComp2.isChecked();
        boolean app3Checked = cbComp3.isChecked();
        prefEditor.putBoolean("app1Checked",app1Checked);
        prefEditor.putBoolean("app2Checked",app2Checked);
        prefEditor.putBoolean("app3Checked",app3Checked);
        prefEditor.commit();
        Toast.makeText(getApplicationContext(), "Added to checkout", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if (id == R.id.nav_men_boots) {
            Intent appliances = new Intent(this, MenBoot.class);
            startActivity(appliances);
            return true;
        } else if (id == R.id.nav_men_dress) {
            Intent tvs = new Intent(this, MenDressShoes.class);
            startActivity(tvs);
            return true;
        } else if (id == R.id.nav_men_casual) {
            Intent computers = new Intent(this, MenCasualShoes.class);
            startActivity(computers);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
