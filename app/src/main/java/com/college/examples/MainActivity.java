package com.college.examples;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.college.examples.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    /**
     *
      * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(click -> {
            String userInput = binding.passwordText.getText().toString();
            if(containsUpperAndLowerCase(userInput)){
                binding.responseText.setText(R.string.upper_lower_case_msg);
            }
            else binding.responseText.setText(R.string.not_complex_msg);
        });
     }

    /** This function checks str and returns true if str
     * has an upper and lower case letter in it
     * @param str - an unused parameter
     *
     * @return Returns true if str has upper and lower case, otherwise false
     */
    boolean containsUpperAndLowerCase( String str){
        boolean foundUpper = false;
        boolean foundLower = false;

        for(int i = 0; i < str.length(); i++)
        {
            //get each character in the string:
            char c = str.charAt(i);
            if(Character.isLowerCase(c))
                foundLower = true;
            else if(Character.isUpperCase(c))
                foundUpper = true;
        }
        //after looked at every character
        return foundLower && foundUpper;
    }
}