package com.example.worldtvgo;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;


import com.example.worldtvgo.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding homeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        View view=homeBinding.getRoot();
        setContentView(view);
//        setContentView(R.layout.activity_home);

    }
}