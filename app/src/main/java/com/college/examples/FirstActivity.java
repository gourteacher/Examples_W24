package com.college.examples;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class FirstActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //For NavigationDrawer:
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(item ->
            {
                String message = null;

                switch(item.getItemId())
                {
                    case R.id.share_item:
                        message = "You clicked on share";
                        break;
                    case R.id.app_bar_search:
                        message = "You clicked on the search";
                        break;
                    case R.id.video_item:
                        message = "You clicked on video";
                        break;
                    case R.id.mail_item:
                        message = "You clicked on mail";
                        break;
                    case R.id.call_item:
                        message = "You clicked on call";
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                if ( message != null ) {
                    Toast.makeText(this, "NavigationDrawer: " + message, Toast.LENGTH_LONG).show();
                }
                return false ;
            }
        );
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
        int id = item.getItemId();

        View v = findViewById(R.id.my_rectangle);

        switch(id) {
            case R.id.red_id:
                v.setBackgroundColor(Color.RED);
                break;

            case R.id.blue_id:
                v.setBackgroundColor(Color.BLUE);
                break;

            case R.id.green_id:
                v.setBackgroundColor(Color.GREEN);
                break;

            case R.id.yellow_id:
                v.setBackgroundColor(Color.YELLOW);
                break;

            case R.id.move_to_next:
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }

}

