package com.college.examples.data;

import androidx.lifecycle.ViewModel;

import com.college.examples.ui.Message;

import java.util.ArrayList;

public class MessageViewModel extends ViewModel {
    private    ArrayList<Message> theMessages = new ArrayList<>();

    public ArrayList<Message> getTheMessages() {
        return theMessages;
    }
}
