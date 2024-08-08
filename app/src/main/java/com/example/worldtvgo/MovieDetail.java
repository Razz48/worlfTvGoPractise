package com.example.worldtvgo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.Adapter.TvShows.CastAdapter;
import com.example.worldtvgo.Adapter.TvShows.TrailerAdapter;
import com.example.worldtvgo.Model.TvShows.Cast;
import com.example.worldtvgo.Model.TvShows.TrailerItem;
import com.example.worldtvgo.databinding.ActivityMovieDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class MovieDetail extends AppCompatActivity {
    ActivityMovieDetailBinding movieDetailBinding;
    List<TrailerItem> trailerList;
    TrailerAdapter trailerAdapter;
    List<Cast> cast;
    CastAdapter castAdapter;
    RecyclerView cast_recycler,trailer_recycler;

    Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieDetailBinding=ActivityMovieDetailBinding.inflate(getLayoutInflater());
        View view=movieDetailBinding.getRoot();
        setContentView(view);
        View placeholderLayout=findViewById(R.id.shimmer_view);
        View detailItemLayout=findViewById(R.id.original_data);
        cast_recycler=detailItemLayout.findViewById(R.id.cast_recycler);
        trailer_recycler=detailItemLayout.findViewById(R.id.trailer_recycler);

        setShimmerPlaceholderItems();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                movieDetailBinding.originalData.setVisibility(View.VISIBLE);
                movieDetailBinding.shimmerView.stopShimmer();
                movieDetailBinding.shimmerView.setVisibility(View.INVISIBLE);
                // Code to execute after 5 seconds
            }
        }, 5000); // 5000 milliseconds = 5 seconds

        trailer_recycler.setLayoutManager(new LinearLayoutManager(this
                ,LinearLayoutManager.HORIZONTAL,false));
        trailerList=new ArrayList<>();

        movieDetailBinding.originalData.setVisibility(View.INVISIBLE);
        movieDetailBinding.shimmerView.startShimmer();


        populateData();
        trailerAdapter=new TrailerAdapter(getApplicationContext(),trailerList,false);
        trailer_recycler.setAdapter(trailerAdapter);


        cast_recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        cast=new ArrayList<>();
        populateCastDetail();
        castAdapter=new CastAdapter(cast);
        cast_recycler.setAdapter(castAdapter);




    }

    private void setShimmerPlaceholderItems() {
        List<TrailerItem> shimmerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Number of shimmer items
            shimmerList.add(new TrailerItem("","",R.drawable.trailer_preview_shimmer)); // Add empty or placeholder items
        }
        trailerAdapter = new TrailerAdapter(getApplicationContext(), shimmerList, true); // Pass true for shimmer mode
        trailer_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        trailer_recycler.setAdapter(trailerAdapter);

    }



    private void populateCastDetail() {

        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        cast.add(new Cast(R.drawable.farah,"Farah Khan"));
    }

    private void populateData() {

        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
    }
}