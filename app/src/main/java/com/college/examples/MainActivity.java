package com.college.examples;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.switch_id);

        btn1.setOnClickListener( c -> {

            DetailFragment detailFragment = new DetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl1, detailFragment);
            ft.commit();
        } );


        Button btn2 = findViewById(R.id.switch_id2);

        btn2.setOnClickListener( c -> {

            ListingFragment listingFragment = new ListingFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl1, listingFragment);
            ft.commit();
        } );


        Button btn3 = findViewById(R.id.switch_id3);

        btn3.setOnClickListener( c -> {

            LoginFragment loginFragment = new LoginFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl1, loginFragment);
            ft.commit();
        } );
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }
}