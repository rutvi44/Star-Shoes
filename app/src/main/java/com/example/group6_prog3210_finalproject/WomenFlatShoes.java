package com.example.group6_prog3210_finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
public class WomenFlatShoes extends AppCompatActivity {

    private CheckBox cbComp1, cbComp2, cbComp3;
    private Button btnAdd, btnCheckout;
    // List to store selected item IDs
    private List<Item> selectedItems; // Declare selectedItems as a list of Item objects


    // Database handler instance
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_flat_shoes);

        // Initialize checkboxes and buttons
        cbComp1 = findViewById(R.id.checkbox_shoe1);
        cbComp2 = findViewById(R.id.checkbox_shoe2);
        cbComp3 = findViewById(R.id.checkbox_shoe3);
        btnAdd = findViewById(R.id.button_add_to_cart);
        btnCheckout = findViewById(R.id.button_checkout);

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
//    private void addToCart() {
//        // Initialize the database handler
//        dbHandler = new DBHandler(this);
//
//        // Clear the list of selected items
//        selectedItems.clear();
//
//        // Check which checkboxes are selected and add their IDs to the list
//        if (cbComp1.isChecked()) {
//            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.flat1ballet);
//
//            // Create an Item object for the first checkbox selection
//            Item item1 = new Item(1, "Ballet Shoe", "Women's Casual Flat Shoes for ballet", 25.99, 1);
//            selectedItems.add(item1);
//        }
//        if (cbComp2.isChecked()) {
//            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.marcfisherflat2);
//
//            // Create an Item object for the second checkbox selection
//            Item item2 = new Item(2, "Marck Fisher", "Women's Marck fisher flat wear", 30.99, 2);
//            selectedItems.add(item2);
//        }
//        if (cbComp3.isChecked()) {
//            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.aldo3flat);
//
//            // Create an Item object for the third checkbox selection
//            Item item3 = new Item(3, "Aldo shoes", "Women's Elegant Flat Shoes from Aldo", 34.99, 3);
//            selectedItems.add(item3);
//        }
//
//
//        // Add the selected items to the database or perform any other necessary action
//        for (Item item : selectedItems) {
//            long itemId = dbHandler.addItem(item);
//            if (itemId != -1) {
//                // Item added successfully
//                Toast.makeText(getApplicationContext(), "Successfully added item to cart", Toast.LENGTH_SHORT).show();
//            } else {
//                // Failed to add item to cart
//                Toast.makeText(getApplicationContext(), "Failed to add item to cart", Toast.LENGTH_SHORT).show();
//                Log.e("addToCart", "Failed to add item to cart: " + item.getName());
//            }
//        }
//    }

    private void addToCart() {
        // Initialize the database handler
        dbHandler = new DBHandler(this);

        // Assuming userId is already initialized or obtained from somewhere
        int userId = 1; // Replace 1 with the actual userId

        // Clear the list of selected items
        selectedItems.clear();

        // Check which checkboxes are selected and add their IDs to the list
        if (cbComp1.isChecked()) {
            // Add item 1 to cart
            dbHandler.addItemToCart(userId, 1, 1);
        }
        if (cbComp2.isChecked()) {
            // Add item 2 to cart
            dbHandler.addItemToCart(userId, 2, 1);
        }
        if (cbComp3.isChecked()) {
            // Add item 3 to cart
            dbHandler.addItemToCart(userId, 3, 1);
        }

        // Display a message indicating that items have been added to the cart
        Toast.makeText(getApplicationContext(), "Successfully added item(s) to cart", Toast.LENGTH_SHORT).show();
    }



    // Method to handle the checkout action
    private void checkout() {
        // Perform the checkout action, e.g., navigate to the checkout screen or process the order
        // You can use the selectedItems list to retrieve the selected items and proceed with the checkout process
        // For demonstration purposes, let's just show a toast message
        Toast.makeText(getApplicationContext(), "Checkout action performed", Toast.LENGTH_SHORT).show();
    }


}