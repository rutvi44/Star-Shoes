package com.example.group6_prog3210_finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class KidsDressShoes extends AppCompatActivity {
    private CheckBox cbShoe1, cbShoe2, cbShoe3;
    private Button btnAddToCart, btnCheckout;
    private List<Item> selectedItems;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_dress_shoes);
        // Initialize checkboxes and buttons
        cbShoe1 = findViewById(R.id.checkbox_shoe1);
        cbShoe2 = findViewById(R.id.checkbox_shoe2);
        cbShoe3 = findViewById(R.id.checkbox_shoe3);
        btnAddToCart = findViewById(R.id.button_add_to_cart);
        btnCheckout = findViewById(R.id.button_checkout);
        // Initialize selected items list
        selectedItems = new ArrayList<>();

        // Add button click listener
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
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
    private void addToCart() {
        // Initialize the database handler
        dbHandler = new DBHandler(this);

        // Clear the list of selected items
        selectedItems.clear();

        // Check which checkboxes are selected and add their IDs to the list
        if (cbShoe1.isChecked()) {
            // Create an Item object for the first checkbox selection
            Item item1 = new Item(1, "Sparkle Light Shoes", "Glittery and colorful with LED lights", 29.99, 1);
            selectedItems.add(item1);
        }
        if (cbShoe2.isChecked()) {
            // Create an Item object for the second checkbox selection
            Item item2 = new Item(2, "Neon Glow Shoes", "Bright neon colors with flashing lights", 34.99, 2);
            selectedItems.add(item2);
        }
        if (cbShoe3.isChecked()) {
            // Create an Item object for the third checkbox selection
            Item item3 = new Item(3, "Glow-in-the-Dark Shoes", "Illuminates in the dark with various patterns", 39.99, 3);
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