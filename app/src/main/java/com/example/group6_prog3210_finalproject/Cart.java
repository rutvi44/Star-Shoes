package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Cart extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private DBHandler dbHandler;
    TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt, btnCheckout;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        dbHandler = new DBHandler(this);

        initView();
        initList();

        // Find the ImageView button by its ID
        ImageView btnBack = findViewById(R.id.btnBack);

        // Set an OnClickListener for the button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the desired activity
                Intent intent = new Intent(Cart.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for the checkout button
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CheckoutActivity
                Intent intent = new Intent(Cart.this, CheckOut.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerViewCart);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.DelTaxTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView2);
        btnCheckout = findViewById(R.id.textView);
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);

        // Assuming you have the userId stored somewhere, replace 1 with the actual userId
        int userId = 1; // Replace 1 with the actual userId
        List<CartItem> cartItems = dbHandler.getAllCartItems(userId);
        adapter = new CartListAdapter(cartItems, dbHandler);
        recyclerViewList.setAdapter(adapter);

        // Calculate and display total fee, tax, delivery charge, and total amount
        double totalFee = calculateTotalFee(cartItems);
        tax = totalFee * 0.13; // Assuming tax rate is 13%
        double deliveryCharge = 5.00; // Assuming a fixed delivery charge
        double totalAmount = totalFee + tax + deliveryCharge;

        totalFeeTxt.setText(String.format("$%.2f", totalFee));
        taxTxt.setText(String.format("$%.2f", tax));
        deliveryTxt.setText(String.format("$%.2f", deliveryCharge));
        totalTxt.setText(String.format("$%.2f", totalAmount));

        // Show/hide empty cart message based on cartItems size
        if (cartItems.isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private double calculateTotalFee(List<CartItem> cartItems) {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += (item.getQuantity() * item.getFee());
        }
        return total;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


}
