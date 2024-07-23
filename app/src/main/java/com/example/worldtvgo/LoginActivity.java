package com.example.worldtvgo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.worldtvgo.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginBinding=ActivityLoginBinding.inflate(getLayoutInflater());
        View view=loginBinding.getRoot();
        setContentView(view);
    }
}
