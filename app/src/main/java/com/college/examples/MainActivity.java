package com.college.examples;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.college.examples.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.computeButton.setOnClickListener(c -> {
            String userInput = binding.userInputId.getText().toString();

            binding.resultTv.setText(userInput);
        });

    }
}