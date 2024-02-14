package com.college.examples.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.college.examples.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FirstActivity extends AppCompatActivity {

    private static final String DATE_FORMAT = "HH:mm:ss MM/dd/yyyy";
    private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ListView myListView = findViewById(R.id.myListView);
        listItems = new ArrayList<>();

        adapter = new ArrayAdapter<>( this,
                android.R.layout.simple_dropdown_item_1line,
                listItems);

        myListView.setAdapter(adapter);

        View.OnClickListener undo = view -> {
            listItems.remove(listItems.size() -1);
            adapter.notifyDataSetChanged();
            Snackbar.make(view, R.string.dialog_remove_item, Snackbar.LENGTH_LONG)
                    .setAction(R.string.dialog_action, null).show();
        };

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            addListItem();
            Snackbar.make(view, R.string.dialog_add_item,
                            Snackbar.LENGTH_LONG)
                    .setAction(R.string.dialog_action, null).show();
            //.setAction("Undo", undo).show();
        });

    }

    private void addListItem() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat(DATE_FORMAT,
                        Locale.US);
        listItems.add(dateformat.format(new Date()));
        adapter.notifyDataSetChanged();
    }
}