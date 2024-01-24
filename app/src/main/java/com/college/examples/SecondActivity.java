package com.college.examples;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.college.examples.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();

        String receivedEmail = i.getStringExtra(MainActivity.EMAIL_KEY);

        binding.secondEmail.setText(receivedEmail);

    }
}