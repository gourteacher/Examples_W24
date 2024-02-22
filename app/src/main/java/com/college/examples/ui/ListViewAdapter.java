package com.college.examples.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.college.examples.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<Message> messages;
    private LayoutInflater inflater;

    ListViewAdapter(Context context, ArrayList<Message> messages) {
        this.messages = messages;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public int getCount() { return messages.size();}

    public Object getItem(int position) { return messages.get(position); }

    public long getItemId(int position) { return position; }

    public View getView(int position, View old, ViewGroup parent)
    {
        //make a new row:
        View newView = inflater.inflate(R.layout.sent_message, parent, false);

        // What message object is at position:
        Message thisRow = messages.get(position);

        //set what the text should be for this row:
        TextView msgView = newView.findViewById(R.id.message);
        msgView.setText( thisRow.getMessage() );

        TextView timeView = newView.findViewById(R.id.time);
        timeView.setText( thisRow.getTimeSent() );

        //return it to be put in the table
        return newView;
    }
}
