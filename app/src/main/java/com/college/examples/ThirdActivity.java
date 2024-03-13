package com.college.examples;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.third_id);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int item_id = item.getItemId();
            if ( item_id == R.id.home_id ) {
                startActivity(new Intent(getApplicationContext(), FirstActivity.class));
            } else if ( item_id == R.id.second_id ) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                return true;
            } else if ( item_id == R.id.third_id ) {
                return true;
            }

            return false;
        });
    }
}