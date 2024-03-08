package com.college.examples;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_example);

        //This gets the toolbar from the layout:
        Toolbar tBar = findViewById(R.id.toolbar);
        setSupportActionBar(tBar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message = null;
        //Look at your menu XML file. Put a case for every id in that file:
        int item_id = item.getItemId();
        {
            //what to do when the menu item is selected:
            if (item_id  == R.id.clear_item ) {
                message = getString(R.string.clear_message);
            }
            else if (item_id  == R.id.search_item) {
                message = getString(R.string.search_message);
            }
            else if ( item_id == R.id.help_item) {
                message = getString(R.string.help_message);
            }
            else if ( item_id  == R.id.mail_item) {
                message = getString(R.string.email_message);
            }
            else if ( item_id == R.id.video_item) {
                message = getString(R.string.video_message);
            }
            else if ( item_id  == R.id.call_item) {
                message = getString(R.string.call_message);
                Intent i = new Intent(getApplicationContext(), SomeActivity.class);
                startActivity(i);
            }
        }
        if ( message != null ) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
        return true;
    }

}