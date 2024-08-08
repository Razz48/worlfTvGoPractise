package com.example.worldtvgo.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldtvgo.Adapter.TvShows.TrailerAdapter;
import com.example.worldtvgo.Model.TvShows.TrailerItem;
import com.example.worldtvgo.R;
import com.example.worldtvgo.databinding.FragmentSynopsisBinding;

import java.util.ArrayList;
import java.util.List;

public class SynopsisFragment extends Fragment {

    FragmentSynopsisBinding synopsisBinding;
    List<TrailerItem> trailerList;
    TrailerAdapter trailerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        synopsisBinding=FragmentSynopsisBinding.inflate(getLayoutInflater());
        View view=synopsisBinding.getRoot();

        synopsisBinding.trailerRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        trailerList=new ArrayList<>();

        populateData();
        trailerAdapter=new TrailerAdapter(getContext(),trailerList,false);
        synopsisBinding.trailerRecycler.setAdapter(trailerAdapter);

        return view;
    }

    private void populateData() {

        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
    }
}