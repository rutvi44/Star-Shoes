package com.example.group6_prog3210_finalproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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

public class WomenHeel extends AppCompatActivity {

    private byte[] convertDrawableToByteArray(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof VectorDrawable || drawable instanceof VectorDrawableCompat) {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        }
        return stream.toByteArray();
    }
    private CheckBox cbComp1, cbComp2, cbComp3;
    private Button btnAdd, btnCheckout;
    // List to store selected item IDs
    private List<Item> selectedItems; // Declare selectedItems as a list of Item objects


    // Database handler instance
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_heel);

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
    private void addToCart() {
        // Initialize the database handler
        dbHandler = new DBHandler(this);

        // Clear the list of selected items
        selectedItems.clear();

        // Check which checkboxes are selected and add their IDs to the list
        // Check which checkboxes are selected and add their IDs to the list
        if (cbComp1.isChecked()) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.michelchor1heel);
            byte[] imageBytes = convertDrawableToByteArray(drawable);
            // Create an Item object for the first checkbox selection
            Item item1 = new Item(1, "Micheal Coal heel", "women's Casual heal  for party", 225.99, 1);
            selectedItems.add(item1);
        }
        if (cbComp2.isChecked()) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.knokr2heel);
            byte[] imageBytes = convertDrawableToByteArray(drawable);
            // Create an Item object for the second checkbox selection
            Item item2 = new Item(2, "KNOKR heel", "Most expensive heel", 30.99, 2);
            selectedItems.add(item2);
        }
        if (cbComp3.isChecked()) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.sandel3lv);
            byte[] imageBytes = convertDrawableToByteArray(drawable);
            // Create an Item object for the third checkbox selection
            Item item3 = new Item(3, "Aldo heel", "Women's Elegant aldo heel", 34.99, 3);
            selectedItems.add(item3);
        }

        // Add the selected items to the database or perform any other necessary action
        for (Item item : selectedItems) {
            long itemId = dbHandler.addItem(item);
            // Check if the item was added successfully
            if (itemId != -1) {
                // Item added successfully
                // You can perform any additional action here if needed
                Toast.makeText(getApplicationContext(), "Successfully added item to cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to add item to cart", Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

}