package com.college.examples.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.college.examples.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter< MessageRecyclerViewAdapter.MessageViewHolder > {
    private final List<Message> mMessageList;
    private final Context mContext;

    public MessageRecyclerViewAdapter(List<Message> messageList, Context context) {
        this.mMessageList = messageList;
        this.mContext = context;
    }

    //It inflates the view hierarchy
    //and creates an instance of the ViewHolder class
    //initialized with the view hierarchy before
    //returning it to the RecyclerView.
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Load a new row from the layout file:
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        //import layout for a row:
        View thisRow = li.inflate(R.layout.row_layout, parent, false);

        return new MessageViewHolder( thisRow );
    }


    //Populates the view hierarchy within the ViewHolder object
    //with the data to be displayed.
    //It is passed the ViewHolder object and an integer
    //value indicating the list item that is to be displayed.
    //This data is then displayed on the layout views using the references
    //created in the constructor method of the ViewHolder class
    //initializes a Row at position in the data array
    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        //need an ArrayList to hold all the messages.
        //MyViewHolder has time and message textViews

        // What message object is at position:
        Message thisRow = mMessageList. get(position);//

        //                      String object:
        holder.timeView.setText( thisRow.getTimeSent() );//what time goes on row position
        holder.messageView.setText( thisRow.getMessage() );//what message goes on row position
    }

    //returns the number of items in the array
    @Override
    public int getItemCount() {
        return mMessageList.size() ; //how many items in the list
    }

    //this holds TextViews on a row:
    public class MessageViewHolder extends RecyclerView.ViewHolder{
        TextView timeView;
        TextView messageView;

        //View will be a ConstraintLayout
        public MessageViewHolder(View itemView) {
            super(itemView);

            timeView = itemView.findViewById(R.id.time);
            messageView = itemView.findViewById(R.id.message);

            itemView.setOnClickListener( v -> {

                //which row was clicked
                int position = getAdapterPosition() ;

                View.OnClickListener listener = v1 -> {
                    mMessageList.remove(position);
                    notifyItemRemoved(position);
                } ;

                Snackbar.make(v, mContext.getString(R.string.sb_item_click) + " " + (position + 1),
                                Snackbar.LENGTH_LONG)
                        .setAction(mContext.getString(R.string.sb_action), listener).show();
            });
        }
    }
}