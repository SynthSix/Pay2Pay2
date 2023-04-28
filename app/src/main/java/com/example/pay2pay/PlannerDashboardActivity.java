package com.example.pay2pay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlannerDashboardActivity extends AppCompatActivity {
    private TextView btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_dashboard);

        // Find the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);

        // Find the "search" item in the menu
        Menu menu = bottomNavigationView.getMenu();
        MenuItem searchMenuItem = menu.findItem(R.id.search_nav);

        // Set the "search" item as checked
        searchMenuItem.setChecked(true);

        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlannerDashboardActivity.this, Transaction.class));

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;

            switch (item.getItemId()) {
                case R.id.home_nav:
                    intent = new Intent(PlannerDashboardActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    break;
                case R.id.search_nav:


                    break;
                case R.id.favorite_nav:
                    intent = new Intent(PlannerDashboardActivity.this, History.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    break;
            }

            return true;

        }
    });

    }
}