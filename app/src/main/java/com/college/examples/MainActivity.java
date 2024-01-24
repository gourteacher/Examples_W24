package com.college.examples;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.college.examples.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    MainModelView model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainModelView.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.resultTv.setText(model.mySaved);
        binding.computeButton.setOnClickListener(c -> {
            String userInput = binding.userInputId.getText().toString();
            model.mySaved = userInput;
            binding.resultTv.setText(userInput);
        });

    }
}