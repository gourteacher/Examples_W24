package com.college.examples.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.college.examples.R;
import com.college.examples.data.MessageViewModel;
import com.college.examples.databinding.ActivityChatRoomBinding;
import com.college.examples.databinding.ReceiveRowBinding;
import com.college.examples.databinding.SentRowBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class ChatRoom extends AppCompatActivity {

    private static final String DATE_FORMAT = "yyyyMMdd:HHmmss";
    private ArrayList<String> theMessages = null;

    private ActivityChatRoomBinding binding ;
    private RecyclerView.Adapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //get the data from the ViewModel:
       MessageViewModel chatModel = new ViewModelProvider(this).get(MessageViewModel.class);
        theMessages = chatModel.theMessages;

        binding.addSomething.setOnClickListener( click ->{
            String newMessage = binding.newMessage.getText().toString();

            Date timeNow = new Date(); //when was this code run
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
            String currentDateandTime = sdf.format( timeNow ); //convert date to String

            if (!newMessage.isEmpty()) {
                theMessages.add( new Message (newMessage + " " + currentDateandTime, true).toString() );
                binding.newMessage.setText("");//remove what you typed
                //tell the recycle view to update:
                myAdapter.notifyItemInserted(theMessages.size()-1);//will redraw
            }
        });

                                //creates rows 0 to 50
        binding.myRecyclerView.setAdapter(
                myAdapter = new RecyclerView.Adapter<MyRowHolder>() {

                    //just inflate the XML
                    @NonNull @Override                                              // implement multiple layouts
                    public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        //viewType will be 0 for the first 3 rows, 1 for everything after

                        if(viewType == 0) {
                            SentRowBinding rowBinding = SentRowBinding.inflate(getLayoutInflater(), parent, false);
                            return new MyRowHolder(rowBinding.getRoot()); //call your constructor below
                        }
                        else {  //after row 3
                            ReceiveRowBinding rowBinding = ReceiveRowBinding.inflate(getLayoutInflater(), parent, false);
                            return new MyRowHolder(rowBinding.getRoot());
                        }
                    }

                    @Override
                    public int getItemViewType(int position) {
                        //given the row, return an layout id for that row

                        if(position < 3)
                            return 0;
                        else
                             return 1;
                    }

                    @Override
                    public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
                        //replace the default text with text at row position

                        String forRow = theMessages.get(position);
                        holder.message.setText(forRow);
                        holder.time.setText("time for row " + position);
                    }

                    //number of rows you want
                    @Override
                    public int getItemCount() {

                        return theMessages.size();
                    }
                }
        ); //populate the list

        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    //this represents a single row on the list
    class MyRowHolder extends RecyclerView.ViewHolder {

        public TextView message;
        public TextView time;
        public MyRowHolder(@NonNull View itemView) {
            super(itemView);
            //like onCreate above
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time); //find the ids from XML to java
        }
    }
}