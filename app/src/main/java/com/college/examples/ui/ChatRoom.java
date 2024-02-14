package com.college.examples.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.college.examples.R;
import com.college.examples.data.MessageViewModel;
import com.college.examples.databinding.ActivityChatRoomBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ChatRoom extends AppCompatActivity {

    private static final String DATE_FORMAT = "yy-MM-dd HH:mm:ss";
    private ActivityChatRoomBinding binding;
    private MessageViewModel model;
    private ListViewAdapter theAdapter;
    @Override
    public void onCreate(Bundle p){
        super.onCreate(p);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(MessageViewModel.class);
        ArrayList<Message> messageList = model.getTheMessages();

        theAdapter = new ListViewAdapter(this, messageList);
        binding.myListView.setAdapter( theAdapter ) ;

        binding.submitButton .setOnClickListener( click ->{
            String whatIsTyped = binding.editText.getText().toString();

            //adding a new message to our history if not empty
            if ( !whatIsTyped.isEmpty()) {
                Message m = createMessage(whatIsTyped);
                messageList.add(m);

                binding.editText.setText("");//clear the text

                //notify that new data was added at a row:
                theAdapter.notifyDataSetChanged();
            }
        });

        binding.myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                messageList.remove(i);
                theAdapter.notifyDataSetChanged();
            }
        });

        binding.myListView.setOnItemLongClickListener( (parent, b, pos, id) -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.alert_title)

                    //What is the message:
                    .setMessage(R.string.alert_message)

                    //what the Yes button does:
                    .setPositiveButton(R.string.alert_positive, (click, arg) -> {
                        Message message = createMessage("Message added");
                        messageList.add(message);
                        theAdapter.notifyDataSetChanged();
                    })
                    //What the No button does:
                    .setNegativeButton(R.string.alert_negative, (click, arg) -> { })

                    //An optional third button:
                    .setNeutralButton(R.string.alert_neutral, (click, arg) -> {  })

                    //Show the dialog
                    .create().show();
            return true;
        });
    }
    public Message createMessage(String message)
    {
        Date timeNow = new Date(); //when was this code run
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        String currentDateandTime = sdf.format( timeNow ); //convert date to String
        return new Message(message, currentDateandTime);
    }
}