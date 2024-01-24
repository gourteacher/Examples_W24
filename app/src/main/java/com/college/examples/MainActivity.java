package com.college.examples;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.college.examples.databinding.ActivityMainBinding;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //same as public static void main(String args[])
    @Override //app starts here
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "In onCreate");

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        //this is the only function call, loads stuff onto screen
        setContentView(binding.getRoot());

        File mySandbox = getFilesDir();//returns where you can save files
        String path = mySandbox.getAbsolutePath();

        if(mySandbox.exists())
        {
            //if yes, then open it
        }
        else {
            //don't load it
        }

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        //prefs had loaded data:
        String nameFromFile = prefs.getString("LoginName", ""); //empty in case LoginName is not there

        binding.emailField.setText(nameFromFile);

        binding.loginButton.setOnClickListener( click->{
            //get file editor:
            SharedPreferences.Editor editor = prefs.edit();
            //do this when clicked:
            Intent newPage = new Intent(MainActivity.this, SecondActivity.class);
            String userInput =  binding.emailField.getText().toString();
            newPage.putExtra("LoginName",userInput); //go to next page
            newPage.putExtra("Age", 34.567);
            startActivity(newPage);
            //put to disk:
            editor.putString("LoginName", userInput);//go to disk
            editor.putFloat("Age", 34.56f);
            editor.apply(); //send to disk

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


    @Override //been garbage collected
    protected void onDestroy() {
        Log.i(TAG, "In onDestroy");
        super.onDestroy();
    }
}