package com.college.examples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    public final static String TAG ="FirstActivity";

    public final static String PREFERENCES_FILE = "MyData";

    @Override     //first called
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calls parent onCreate()

        Log.i(TAG, "In onCreate, creating the objects");
        setContentView( R.layout.activity_first); //loads XML on screen

        SharedPreferences prefs = getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        //Read preferences
        String previous = prefs.getString("ReserveName", "Default Value");
        TextView edit = findViewById(R.id.reserved_name);
        edit.setText(previous);

        //SharedPreferences
        Button btn3 = findViewById(R.id.shared_preferences);
        btn3.setOnClickListener( (  click ) ->
        {
            EditText userText = findViewById(R.id.user_input);
            String userTyped = userText.getText().toString();
            Intent nextPage = new Intent(FirstActivity.this,   SharedPrefsActivity.class  );

            nextPage.putExtra("USERINPUT", userTyped);
            nextPage.putExtra("MONTH", 10);
            nextPage.putExtra("OTHER INFO", 3.14);

            //Make the transition:
            startActivity(    nextPage  );
        });
    }

    @Override //screen is visible but not responding
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "In onStart, visible but not responding");
    }

    @Override //screen is visible but not responding
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In onResume");
    }

    @Override //screen is visible but not responding
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "In onPause");
    }

    @Override //not visible
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "In onStop");
    }

    @Override  //garbage collected
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "In onDestroy");
    }
}