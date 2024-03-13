package com.college.examples;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FirstActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home_id);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int item_id = item.getItemId();
            if ( item_id == R.id.home_id ) {
                return true;
            } else if ( item_id == R.id.second_id ) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                return true;
            } else if ( item_id == R.id.third_id ) {
                    startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
                    return true;
            }
            return false;
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        View v = findViewById(R.id.my_rectangle);

        int item_id = item.getItemId();

        if ( R.id.red_id == item_id ) {
            v.setBackgroundColor(Color.RED);
        }   else if ( R.id.blue_id == item_id ) {
            v.setBackgroundColor(Color.BLUE);
        }   else if ( R.id.green_id == item_id ) {
            v.setBackgroundColor(Color.GREEN);
        }   else if ( R.id.yellow_id == item_id ) {
                v.setBackgroundColor(Color.YELLOW);
        }  else if ( R.id.move_to_next == item_id ) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}

