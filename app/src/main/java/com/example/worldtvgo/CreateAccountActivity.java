package com.example.worldtvgo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.worldtvgo.databinding.ActivityCreateAccountBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CreateAccountActivity extends AppCompatActivity {

    ActivityCreateAccountBinding createAccountBinding;
    private boolean isTermChecked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createAccountBinding=ActivityCreateAccountBinding.inflate(getLayoutInflater());
        View view=createAccountBinding.getRoot();
        setContentView(view);

        String text="By signing up you agree to the Terms & Conditions and Privacy Policy";
        SpannableString spannableString=new SpannableString(text);


        createAccountBinding.termsConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialogue(new TermsAndConditionFragment());
            }
        });





        @SuppressLint("ResourceAsColor")
        ForegroundColorSpan termColorSpan=new ForegroundColorSpan(R.color.createAnAccount);
        int termStart=text.indexOf("Terms & Conditions");
        int termEnd=termStart+"Terms & Conditions".length();
        spannableString.setSpan(termColorSpan,termStart,termEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        @SuppressLint("ResourceAsColor")
        ForegroundColorSpan privacyColorSpan=new ForegroundColorSpan(R.color.createAnAccount);
        int privacyStart=text.indexOf("Privacy Policy");
        int privacyEnd=privacyStart+"Privacy Policy".length();
        spannableString.setSpan(privacyColorSpan,privacyStart,privacyEnd,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    private void showBottomSheetDialogue(BottomSheetDialogFragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragment.show(fragmentManager,fragment.getTag());

    }
}
