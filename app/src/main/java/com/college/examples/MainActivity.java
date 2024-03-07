package com.college.examples;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.college.examples.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    //Replace it with your own key or the one provided in Brightspace
    private final String MY_KEY = "YOUR_KEY_HERE"; 
    private final String URL_REQUEST_DATA = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String URL_API_PARAM = "&appid=" + MY_KEY +  "&units=metric";

    protected String cityName;
    protected RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView(binding.getRoot());

        queue = Volley.newRequestQueue(this);

        binding.forecastButton.setOnClickListener(click -> {
            cityName = binding.editText.getText().toString();

            try {
                if (!cityName.isEmpty()) {

                    String url = URL_REQUEST_DATA + URLEncoder.encode(cityName, "UTF-8") + URL_API_PARAM;

                    //this goes in the button click handler:
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                            (response) -> {
                                try {
                                    JSONObject coord = response.getJSONObject("coord");
                                    JSONArray weatherArray = response.getJSONArray("weather");
                                    JSONObject position0 = weatherArray.getJSONObject(0);
                                    String description = position0.getString("description");

                                    JSONObject mainObject = response.getJSONObject("main");
                                    double current = mainObject.getDouble("temp");
                                    double min = mainObject.getDouble("temp_min");
                                    double max = mainObject.getDouble("temp_max");

                                    binding.tvDescription.setText(description);
                                    binding.tvCurrentVal.setText(String.format(Locale.CANADA, "%.1f°", current));
                                    binding.tvMinVal.setText(String.format(Locale.CANADA, "%.1f°", min));
                                    binding.tvMaxVal.setText(String.format(Locale.CANADA, "%.1f°", max));

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            },
                            (error) -> {
                                Log.e(TAG, "Error:" + error.getMessage());
                                Snackbar.make(click, R.string.error_msg, Toast.LENGTH_SHORT).show();
                            });
                    queue.add(request);
                } else {
                    Snackbar.make(click, R.string.error_msg, Snackbar.LENGTH_SHORT).show();
                }
            }
            catch (Exception e) {
                Log.e(TAG, "Error encoding city name");
            }
        });
    }
}