package com.college.examples;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.college.examples.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    /**
     *
      * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

     }


}