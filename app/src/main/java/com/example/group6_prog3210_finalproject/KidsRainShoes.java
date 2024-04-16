package com.example.group6_prog3210_finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class KidsRainShoes extends AppCompatActivity {

    private CheckBox cbBoot1, cbBoot2, cbBoot3;
    private Button btnAdd, btnCheckout;
    private List<Item> selectedItems;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_rain_shoes);
        cbBoot1 = findViewById(R.id.checkbox_boot1);
        cbBoot2 = findViewById(R.id.checkbox_boot2);
        cbBoot3 = findViewById(R.id.checkbox_boot3);
        btnAdd = findViewById(R.id.button_add_to_cart);
        btnCheckout = findViewById(R.id.button_checkout);

        selectedItems = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkout();
            }
        });
    }

    private void addToCart() {
        dbHandler = new DBHandler(this);
        selectedItems.clear();

        if (cbBoot1.isChecked()) {
            Item item1 = new Item(1, "Fendi shoes", "Available in various colors", 25.99, 1);
            selectedItems.add(item1);
        }
        if (cbBoot2.isChecked()) {
            Item item2 = new Item(2, "Prada Rain Boot", "Waterproof and comfortable", 30.99, 2);
            selectedItems.add(item2);
        }
        if (cbBoot3.isChecked()) {
            Item item3 = new Item(3, "LV  Rain boot", "Cute and stylish design", 34.99, 3);
            selectedItems.add(item3);
        }

        for (Item item : selectedItems) {
            long itemId = dbHandler.addItem(item);
            if (itemId != -1) {
                Toast.makeText(getApplicationContext(), "Successfully added item to cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to add item to cart", Toast.LENGTH_SHORT).show();
                Log.e("addToCart", "Failed to add item to cart: " + item.getName());
            }
        }
    }

    private void checkout() {
        Toast.makeText(getApplicationContext(), "Checkout action performed", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
}