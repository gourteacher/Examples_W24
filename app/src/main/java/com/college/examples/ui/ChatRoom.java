package com.college.examples.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.college.examples.data.MessageViewModel;
import com.college.examples.databinding.ActivityChatRoomBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ChatRoom extends AppCompatActivity {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private ActivityChatRoomBinding binding;

    private MessageViewModel model;

    @Override
    public void onCreate(Bundle p){
        super.onCreate(p);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(MessageViewModel.class);
        ArrayList<Message> messageList = model.getTheMessages();

        MessageRecyclerViewAdapter  theAdapter = new MessageRecyclerViewAdapter(messageList, getApplicationContext());
        binding.myRecycleView.setAdapter(theAdapter) ;
        binding.myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        //rView.setLayoutManager(new GridLayoutManager (this, 2) );

        binding.submitButton.setOnClickListener( click ->{
            String whatIsTyped = binding.editText.getText().toString();
            Date timeNow = new Date(); //when was this code run

            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
            String currentDateandTime = sdf.format( timeNow ); //convert date to String

            //adding a new message to our history if not empty
            if (!whatIsTyped.isEmpty()) {
                messageList.add(new Message(whatIsTyped, currentDateandTime));
                binding.editText.setText("");//clear the text
                //notify that new data was added at a row:
                theAdapter.notifyItemInserted(messageList.size() - 1); //at the end of ArrayList,
            }
        });
    }
}