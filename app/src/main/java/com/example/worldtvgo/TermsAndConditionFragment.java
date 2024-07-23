package com.example.worldtvgo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldtvgo.databinding.FragmentTermsAndConditionBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class TermsAndConditionFragment extends BottomSheetDialogFragment {

    FragmentTermsAndConditionBinding termsAndConditionBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        termsAndConditionBinding=FragmentTermsAndConditionBinding.inflate(getLayoutInflater());
        View view=termsAndConditionBinding.getRoot();


        return view;
    }
}