package com.college.examples.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//data survives rotation changes
public class MainViewModel extends ViewModel {

    //survive orientation changes
    public MutableLiveData< Boolean > radioIsSelected = new MutableLiveData<>();

    public MutableLiveData< Boolean > checkBoxIsSelected = new MutableLiveData<>();

    public MutableLiveData< Boolean > switchIsSelected = new MutableLiveData<>();
}
