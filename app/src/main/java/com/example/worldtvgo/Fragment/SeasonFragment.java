package com.example.worldtvgo.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.worldtvgo.Adapter.TvShows.TrailerAdapter;
import com.example.worldtvgo.Model.TvShows.TrailerItem;
import com.example.worldtvgo.R;
import com.example.worldtvgo.databinding.FragmentSeasonBinding;
import com.example.worldtvgo.databinding.SeasonDetailItemBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class SeasonFragment extends Fragment {

    List<TrailerItem> trailerList;
    TrailerAdapter trailerAdapter;

    ArrayAdapter<CharSequence> seasonAdapter;


    FragmentSeasonBinding seasonBinding;

    Handler handler=new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        seasonBinding=FragmentSeasonBinding.inflate(getLayoutInflater());
        View view=seasonBinding.getRoot();
        SeasonDetailItemBinding seasonDetailItemBinding=SeasonDetailItemBinding.bind(seasonBinding.originalData.findViewById(R.id.season_detai_item_root));


        seasonBinding.shimmerView.startShimmer();
        seasonBinding.originalData.setVisibility(View.INVISIBLE);
        // Setup RecyclerView

        trailerList = new ArrayList<>();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                seasonBinding.shimmerView.setVisibility(View.INVISIBLE);
                seasonBinding.shimmerView.stopShimmer();
                seasonBinding.originalData.setVisibility(View.VISIBLE);


                seasonDetailItemBinding.episodeRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
                trailerAdapter = new TrailerAdapter(getContext(), trailerList,false);
                seasonDetailItemBinding.episodeRecyclerView.setAdapter(trailerAdapter);


                loadSeason(0);
            }
        },2000);


        //creating a space between each tabitem
        for(int i=0; i < seasonDetailItemBinding.seasonTab.getTabCount(); i++) {
            View tab = ((ViewGroup) seasonDetailItemBinding.seasonTab.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(0, 0, 20, 0);
            tab.requestLayout();

        }


        // Setup TabLayout with listener
        seasonDetailItemBinding.seasonTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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


