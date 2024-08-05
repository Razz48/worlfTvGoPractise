package com.example.worldtvgo.Fragment;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldtvgo.Adapter.TrailerAdapter;
import com.example.worldtvgo.Model.TrailerItem;
import com.example.worldtvgo.R;
import com.example.worldtvgo.databinding.FragmentSeasonBinding;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SeasonFragment extends Fragment {

    List<TrailerItem> trailerList;
    TrailerAdapter trailerAdapter;

    ArrayAdapter<CharSequence> seasonAdapter;


    FragmentSeasonBinding seasonBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        seasonBinding=FragmentSeasonBinding.inflate(getLayoutInflater());
        View view=seasonBinding.getRoot();


        // Setup RecyclerView

        trailerList = new ArrayList<>();

        seasonBinding.episodeRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        trailerAdapter = new TrailerAdapter(getContext(), trailerList);
        seasonBinding.episodeRecyclerView.setAdapter(trailerAdapter);


        // Setup TabLayout with listener
        seasonBinding.seasonTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position=tab.getPosition();
                loadSeason(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        loadSeason(0);




        return view;


    }

    private void loadSeason(int seasonNumber) {

        trailerList.clear();

        switch (seasonNumber){
            case 0: // Season 1
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
                break;
            case 1: // Season 2
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.season_two_img));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.season_two_img));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.season_two_img));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.season_two_img));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.season_two_img));
                trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.season_two_img));

                break;
            case 2: // Season 3
               populateData();
                break;
        }
        trailerAdapter.notifyDataSetChanged();
    }

    private void populateData() {

        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
    }

}



























//    private void initPopupWindow(ArrayAdapter<String> adapter) {
//
//
//        // Inflate the custom layout/view
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        View customView = inflater.inflate(R.layout.custom_dropdown, null);
//
//        // Initialize a new instance of popup window
//        popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
//
//        // Get a reference to the ListView
//        ListView listView = customView.findViewById(R.id.dropdown_list);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Get the selected item
//                String selectedSeason = parent.getItemAtPosition(position).toString();
//                seasonBinding.episodeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
//                populateData();
//                trailerAdapter=new TrailerAdapter(getContext(),trailerList);
//                seasonBinding.episodeRecyclerView.setAdapter(trailerAdapter);
//                // Set the selected item text
//
//                seasonBinding.textviewSeason.setText(selectedSeason);
////                seasonBinding.textViewSeason.setText(selectedSeason);
//                // Display a toast or handle the selection
//                Toast.makeText(getActivity(), "Selected: " + selectedSeason, Toast.LENGTH_SHORT).show();
//                // Dismiss the popup window
//                popupWindow.dismiss();
//            }
//        });

        // Set some properties of the popup window
//        popupWindow.setFocusable(true);
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_background));


