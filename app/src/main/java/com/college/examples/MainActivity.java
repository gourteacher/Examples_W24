package com.college.examples;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.college.examples.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private static final String URL_TAG = "GOOGLE_TAG";

    private static final String URL_GOOGLE = "https://www.google.com";
    private RequestQueue queue;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView(binding.getRoot());

        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);
        String my_url = URL_GOOGLE;

        binding.fetchButton.setOnClickListener(v -> {
            fetchGoogle(my_url);
        });

        binding.clearButton.setOnClickListener(v -> {
            binding.theText.setText("");
        });
    }

    private void fetchGoogle(String url) {
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // Display the first 500 characters of the response string.
                    binding.theText.setText(getString(R.string.response_msg, response.substring(0,500)));
                },
                error -> binding.theText.setText(R.string. error_msg)
        );
        // Add TAG to request
        stringRequest.setTag(URL_TAG);

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
    @Override
    protected void onStop() {
        super.onStop();
        if (queue != null) {
            queue.cancelAll(URL_TAG);
            queue.stop();
        }
    }
}