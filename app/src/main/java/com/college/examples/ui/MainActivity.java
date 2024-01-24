package com.college.examples.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.college.examples.data.MainViewModel;
import com.college.examples.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    //same as public static void main(String args[])
    @Override //app starts here
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //this is the only function call, loads stuff onto screen
        setContentView(binding.getRoot());

        binding.checkBox.setOnCheckedChangeListener(   (button, isChecked) -> {
            viewModel.checkBoxIsSelected.postValue(isChecked);
        } );

        binding.radioButton.setOnCheckedChangeListener(   (button, isChecked) -> {
            viewModel.radioIsSelected.postValue(isChecked);
        } );

        binding.mySwitch.setOnCheckedChangeListener(   (button, isChecked) -> {
            viewModel.switchIsSelected.postValue(isChecked);
        } );

        viewModel.checkBoxIsSelected.observe(this, selected -> {
            binding.checkBox.setChecked(selected);
        });

        viewModel.radioIsSelected.observe(this, selected -> {
            binding.radioButton.setChecked(selected);
        });

        viewModel.switchIsSelected.observe(this, selected -> {
            binding.mySwitch.setChecked(selected);
        });

    }
}
