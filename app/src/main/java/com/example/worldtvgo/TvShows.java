package com.example.worldtvgo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.worldtvgo.Adapter.TrailerAdapter;
import com.example.worldtvgo.Fragment.SeasonFragment;
import com.example.worldtvgo.Fragment.SynopsisFragment;
import com.example.worldtvgo.Model.TrailerItem;
import com.example.worldtvgo.databinding.ActivityTvShowsBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TvShows extends AppCompatActivity {
    ActivityTvShowsBinding tvShowsBinding;
    List<TrailerItem> trailerList;
    TrailerAdapter trailerAdapter;

    private Handler handler = new Handler();
    private Runnable hideRunnable = new Runnable() {
        @Override
        public void run() {
            hideSystemUI();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvShowsBinding=ActivityTvShowsBinding.inflate(getLayoutInflater());
        View view=tvShowsBinding.getRoot();

        setContentView(view);
//
//        tvShowsBinding.trailerRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        trailerList=new ArrayList<>();
//
//        populateData();
//       trailerAdapter=new TrailerAdapter(getApplicationContext(),trailerList);
//       tvShowsBinding.trailerRecycler.setAdapter(trailerAdapter);

        SynopsisFragment synopsisFragment=new SynopsisFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.frame_layout,synopsisFragment).commit();

        tvShowsBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0:
                        fragment=new SynopsisFragment();
                        break;

                    case 1:
                        fragment=new SeasonFragment();
                        break;


                }
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,fragment);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        hideSystemUI();





    }

    private void hideSystemUI() {
        getWindow().getDecorView().setOnApplyWindowInsetsListener((v, insets) -> {
            v.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN);
            return insets.consumeSystemWindowInsets();
        });
    }
    private void delayedHideSystemUI() {
        handler.removeCallbacks(hideRunnable);
        handler.postDelayed(hideRunnable, 1000); // Hide after 3 seconds
    }


//    private void populateData() {
//       trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//       trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//       trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//       trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//       trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            delayedHideSystemUI();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }

}

