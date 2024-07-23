package com.example.worldtvgo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.worldtvgo.databinding.ActivityResetPasswordBinding;

public class ResetPassword extends AppCompatActivity {
    ActivityResetPasswordBinding resetPasswordBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resetPasswordBinding=ActivityResetPasswordBinding.inflate(getLayoutInflater());
        View view=resetPasswordBinding.getRoot();
        setContentView(view);



        resetPasswordBinding.newPassword.getEditText().getText().toString();
        resetPasswordBinding.confirmPassword.getEditText().getText().toString();

        EditText[] otpInputs = {
                resetPasswordBinding.otp1,
                resetPasswordBinding.otp2,
                resetPasswordBinding.otp3,
                resetPasswordBinding.otp4,
                resetPasswordBinding.otp5,
                resetPasswordBinding.otp6
        };

        for (int i = 0; i < otpInputs.length; i++) {
            final int index = i;
            otpInputs[index].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1 && index < otpInputs.length - 1) {
                        otpInputs[index + 1].requestFocus();
                    }
                    if(s.length() == 1 && index == otpInputs.length - 1){
                        resetPasswordBinding.newPassword.requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (index > 0 && otpInputs[index].getText().toString().isEmpty()) {
                        otpInputs[index - 1].requestFocus();
                    }

                }
            });


//            otpInputs[index].setOnKeyListener(new View.OnKeyListener() {
//                @Override
//                public boolean onKey(View v, int keyCode, KeyEvent event) {
//                    if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && otpInputs[index].getText().toString().isEmpty() && index > 0) {
//                        otpInputs[index - 1].requestFocus();
//                    }
//                    return false;
//                }
//            });
        }

        resetPasswordBinding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = resetPasswordBinding.otp1.getText().toString() +
                        resetPasswordBinding.otp2.getText().toString() +
                        resetPasswordBinding.otp3.getText().toString() +
                        resetPasswordBinding.otp4.getText().toString() +
                        resetPasswordBinding.otp5.getText().toString() +
                        resetPasswordBinding.otp6.getText().toString();

                Toast.makeText(ResetPassword.this, "Otp number is " + otp, Toast.LENGTH_SHORT).show();


            }
        });
    }
}
