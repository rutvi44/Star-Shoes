package com.example.group6_prog3210_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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

        // Find the LinearLayout representing the "Aboiut" tab
        LinearLayout Tab = findViewById(R.id.aboutPage);

        // Set a click listener for the "About" tab
        Tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this, ActivityAbout.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });

        //for catagories
        // Find the LinearLayout representing the "Categories" tab
        LinearLayout Tab2 = findViewById(R.id.catagoryPageHome);

        // Set a click listener for the "Categories" tab
        Tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this, Categories.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });



        // for order history
        // Find the LinearLayout representing the "Categories" tab
        LinearLayout Tab3 = findViewById(R.id.OrderHistoryHome);

        // Set a click listener for the "Categories" tab
        Tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this,OrderHistory.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });

        //for cart
        // Find the LinearLayout representing the "Categories" tab
        LinearLayout Tab4 = findViewById(R.id.cartHome);

        // Set a click listener for the "Categories" tab
        Tab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this, Cart.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });
        //for stroe location

        // Find the LinearLayout representing the "Categories" tab
        LinearLayout Tab5 = findViewById(R.id.storeLocationHome);

        // Set a click listener for the "Categories" tab
        Tab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this, StoreLocation.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });
        //for chek out

        // Find the LinearLayout representing the "Categories" tab
        LinearLayout Tab6 = findViewById(R.id.checkOutPageHome);

        // Set a click listener for the "Categories" tab
        Tab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this, CheckOut.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });
        // for logout

        // Find the LinearLayout representing the "Categories" tab
        LinearLayout Tab7 = findViewById(R.id.LogoutHome);

        // Set a click listener for the "Categories" tab
        Tab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this, Logout.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });

        // for store rating
        // Find the LinearLayout representing the "Categories" tab
        LinearLayout Tab8 = findViewById(R.id.storeRatingHome);

        // Set a click listener for the "Categories" tab
        Tab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the CategoryActivity
                Intent intent = new Intent(HomeActivity.this, StoreRating.class);

                // Start the CategoryActivity
                startActivity(intent);
            }
        });

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
            Intent menBoots = new Intent(this, MenBoot.class);
            startActivity(menBoots);
            return true;
        } else if (itemId == R.id.nav_men_dress) {
            Intent menDress = new Intent(this, MenDressShoes.class);
            startActivity(menDress);
            return true;
        } else if (itemId == R.id.nav_men_casual) {
            Intent menCasual = new Intent(this, MenCasualShoes.class);
            startActivity(menCasual);
            return true;
        } else if (itemId == R.id.nav_Women_flats) {
            Intent wFlats = new Intent(this, WomenFlatShoes.class);
            startActivity(wFlats);
        return true;
        } else if (itemId==R.id.nav_Women_heels) {
            Intent wHeels = new Intent(this, WomenHeel.class);
            startActivity(wHeels);
            return true;
        } else if (itemId==R.id.nav_Women_wedges) {
            Intent wWedges = new Intent(this, WomenWedges.class);
            startActivity(wWedges);
            return true;
        } else if (itemId==R.id.nav_store_locator) {
            Intent store = new Intent(this, StoreLocation.class);
            startActivity(store);
            return true;
        }else if (itemId == R.id.nav_cart) {
            Intent cart = new Intent(this, Cart.class);
            startActivity(cart);
            return true;
        }else if (itemId == R.id.nav_checkout) {
            Intent checkout = new Intent(this, CheckOut.class);
            startActivity(checkout);
            return true;
        }else if (itemId == R.id.nav_logout) {
            Intent logout = new Intent(this, Logout.class);
            startActivity(logout);
            return true;
        }else if (itemId == R.id.nav_order_history) {
            Intent orderHist = new Intent(this, OrderHistory.class);
            startActivity(orderHist);
            return true;
        }else if (itemId == R.id.nav_store_rating) {
            Intent storeRating = new Intent(this, StoreRating.class);
            startActivity(storeRating);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
