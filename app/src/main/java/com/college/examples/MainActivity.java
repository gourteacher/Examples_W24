package com.college.examples;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This shows how to use Android's default email app to send an email:
        Button temp = findViewById(R.id.sendEmailExample);
        temp.setOnClickListener(click ->{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"email@example.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
            intent.putExtra(Intent.EXTRA_TEXT, "body text");
            startActivity(intent);

        });

        //This shows how to use Android's default web view app to view a web page:
        temp = findViewById(R.id.viewURL);
        temp.setOnClickListener( click -> {

            String url = "http://www.algonquincollege.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData( Uri.parse(url) );
            startActivity(i);

        });

        //This shows how to use Android's default web view app to view a web page:
        temp = findViewById(R.id.makePhoneCall);
        try {
            temp.setOnClickListener(click -> {
                String url = "tel:" + "6137274700";
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse(url));

                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }
            });
        } catch (SecurityException se) {
            se.printStackTrace();
        }


        Button term = findViewById( R.id.intent_return_button);
        term.setOnClickListener(  click ->  { finish(); } );
    }
}
