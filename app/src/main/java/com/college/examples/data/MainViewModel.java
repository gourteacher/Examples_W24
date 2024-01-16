package com.college.examples.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//data survives rotation changes
public class MainViewModel extends ViewModel {

    //observe this object:
    public MutableLiveData<String> userString = new MutableLiveData("");
    public MutableLiveData<Boolean> onOrOff = new MutableLiveData<>(false);
}
