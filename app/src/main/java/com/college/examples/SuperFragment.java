package com.college.examples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SuperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SuperFragment extends Fragment {


    private  float visibility = 1.0f;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SuperFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SuperFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SuperFragment newInstance(String param1, String param2) {
        SuperFragment fragment = new SuperFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_super, container, false);

        Button btn = v.findViewById(R.id.super_button);

        btn.setOnClickListener( c -> {
            NavController navController = Navigation.findNavController (v);
            navController.navigate(R.id.action_superFragment_to_loginFragment);
        } );

        Button btn2 = v.findViewById(R.id.animate_btn);

        btn2.setOnClickListener( c -> {
            TextView tv = v.findViewById(R.id.textView2);
            my_animate(tv);

       });

        return v;
    }

    private void my_animate(TextView tv) {
        tv.animate().alpha(visibility);
        visibility -= 0.10f;
        if (visibility <= 0.0f) {
            visibility = 1.0f;
        }
    }

}