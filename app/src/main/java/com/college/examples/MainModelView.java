package com.college.examples;

import androidx.lifecycle.MutableLiveData;

public class MainModelView extends androidx.lifecycle.ViewModel {
    public MutableLiveData <String> mySaved = new MutableLiveData<>();
}
