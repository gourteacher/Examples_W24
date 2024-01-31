package com.college.examples;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.college.examples.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String EMAIL_KEY = "EmailAddress";

    //same as public static void main(String args[])
    @Override //app starts here
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "In onCreate");

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        //this is the only function call, loads stuff onto screen
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener( click->{

            //do this when clicked:
            Intent newPage = new Intent(MainActivity.this, SecondActivity.class);
            String userInput =  binding.emailField.getText().toString();
            newPage.putExtra(EMAIL_KEY,userInput); //go to next page
            startActivity(newPage);
        } );
    }


    @Override //app is visible
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "In onStart");
    }

    @Override  // app now responds to clicks
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "In onResume");
    }

    @Override //opposite to onResume, no longer getting clicks
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "In onPause");
    }
    @Override//no longer visible
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "In onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "In onRestart");
    }

    @Override //been garbage collected
    protected void onDestroy() {
        Log.i(TAG, "In onDestroy");
        super.onDestroy();
    }
}