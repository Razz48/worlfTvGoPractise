package com.example.worldtvgo;

import android.content.Intent;
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
import com.facebook.shimmer.ShimmerFrameLayout;

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

//        castShimmer=placeholderLayout.findViewById(R.id.cast_shimmer);
//        trailerShimmer=placeholderLayout.findViewById(R.id.trailer_shimmer);

        // Set up shimmer effect
        movieDetailBinding.shimmerView.startShimmer();



        movieDetailBinding.originalData.setVisibility(View.INVISIBLE);






        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                movieDetailBinding.originalData.setVisibility(View.VISIBLE);
                movieDetailBinding.shimmerView.stopShimmer();
                movieDetailBinding.shimmerView.setVisibility(View.INVISIBLE);
                // Code to execute after 5 seconds
                populateData();
                populateCastDetail();
            }
        }, 1000); // 5000 milliseconds = 5 seconds

        movieDetailBinding.originalData.findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MovieDetail.this,MoviePlayer.class);
                startActivity(intent);
            }
        });





    }



    private void populateCastDetail() {
        cast=new ArrayList<>();
        //set up cast recycler view
        cast_recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        castAdapter=new CastAdapter(cast);
        cast_recycler.setAdapter(castAdapter);


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
        trailerList=new ArrayList<>();

        // Set up trailer RecyclerView
        trailer_recycler.setLayoutManager(new LinearLayoutManager(this
                ,LinearLayoutManager.HORIZONTAL,false));
        trailerAdapter=new TrailerAdapter(getApplicationContext(),trailerList,false);
        trailer_recycler.setAdapter(trailerAdapter);


        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
    }
}