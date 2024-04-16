package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MenDressShoes extends AppCompatActivity {
    private CheckBox cbComp1,cbComp2,cbComp3;
    private Button btnAdd,btnCheckout;
    private List<Item> selectedItems; // Declare selectedItems as a list of Item objects


    // Database handler instance
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mendressshoes);
        // Initialize checkboxes and buttons
        cbComp1 = findViewById(R.id.cbComp1);
        cbComp2 = findViewById(R.id.cbComp2);
        cbComp3 = findViewById(R.id.cbComp3);
        btnAdd = findViewById(R.id.btnAdd);
        btnCheckout = findViewById(R.id.checkout_button);

        // Initialize selected items list
        selectedItems = new ArrayList<>();

        // Add button click listener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle adding selected items to the cart
                addToCart();
            }
        });

        // Checkout button click listener
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle checkout action
                checkout();
            }
        });
    }

    // Method to add selected items to the cart
    // Method to add selected items to the cart
    private void addToCart() {
        // Initialize the database handler
        dbHandler = new DBHandler(this);

        // Clear the list of selected items
        selectedItems.clear();

        // Check which checkboxes are selected and add their IDs to the list
        if (cbComp1.isChecked()) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.flat1ballet);

            // Create an Item object for the first checkbox selection
            Item item1 = new Item(1, "OXFORd Shoe", "Boys Oxford Shoes ", 225.99, 1);
            selectedItems.add(item1);
        }
        if (cbComp2.isChecked()) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.marcfisherflat2);

            // Create an Item object for the second checkbox selection
            Item item2 = new Item(2, "Chuka", "Boys's Chuka wear", 10.99, 2);
            selectedItems.add(item2);
        }
        if (cbComp3.isChecked()) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.aldo3flat);

            // Create an Item object for the third checkbox selection
            Item item3 = new Item(3, "Loafers", "Boys's Elegant Flat Shoes from Loafers", 32.99, 3);
            selectedItems.add(item3);
        }


        // Add the selected items to the database or perform any other necessary action
        for (Item item : selectedItems) {
            long itemId = dbHandler.addItem(item);
            if (itemId != -1) {
                // Item added successfully
                Toast.makeText(getApplicationContext(), "Successfully added item to cart", Toast.LENGTH_SHORT).show();
            } else {
                // Failed to add item to cart
                Toast.makeText(getApplicationContext(), "Failed to add item to cart", Toast.LENGTH_SHORT).show();
                Log.e("addToCart", "Failed to add item to cart: " + item.getName());
            }
        }
    }


    // Method to handle the checkout action
    private void checkout() {
        // Perform the checkout action, e.g., navigate to the checkout screen or process the order
        // You can use the selectedItems list to retrieve the selected items and proceed with the checkout process
        // For demonstration purposes, let's just show a toast message
        Toast.makeText(getApplicationContext(), "Checkout action performed", Toast.LENGTH_SHORT).show();
    }

}
