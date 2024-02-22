package com.college.examples;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.college.examples.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PersonDAO dao;
    private ArrayList<String> people;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase db = AppDatabase.getInstance(this);
        dao = db.getPersonDAO();

        //ListView Setup
        people = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                people);
        binding.personList.setAdapter(adapter);

        binding.btnAdd.setOnClickListener(v ->  saveData(v));

        binding.btnClear.setOnClickListener( v -> clearData());

        binding.btnLoad.setOnClickListener( v ->  loadData());

    }

    private void saveData(View v) {
        String lastname = binding.lnameEdit.getText().toString();
        String firstname = binding.fnameEdit.getText().toString();
        if(!lastname.isEmpty()  && !firstname.isEmpty()) {
            binding.lnameEdit.setText("");
            binding.fnameEdit.setText("");
            Person person = new Person(lastname, firstname);
            adapter.add(String.format("%s, %s", lastname, firstname));
            adapter.notifyDataSetChanged();
            //Add to the database
            new Thread(() -> {
                dao.insertPerson(person);
            }).start();
        } else {
            Snackbar.make(v, R.string.error_string_empty, Snackbar.LENGTH_LONG).show();
        }
    }

    private void  clearData() {
        new Thread(() -> {
            people.clear();
            dao.deleteAll();
        }).start();
        //Notification to the listView has to occur in the main UI thread
        adapter.notifyDataSetChanged();
    }

    private void  loadData() {
        new Thread(() -> {
            List<Person> all = dao.listPeople();
            people.clear();
            for (Person e:all) {
                people.add(String.format("%s, %s", e.last_name, e.first_name));
            }
        }).start();
        //Notification to the listView has to occur in the main UI thread
        adapter.notifyDataSetChanged();
    }

}

