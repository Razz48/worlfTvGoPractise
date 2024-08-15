package com.example.worldtvgo.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.worldtvgo.Adapter.TvShows.CastAdapter;
import com.example.worldtvgo.Adapter.TvShows.TrailerAdapter;
import com.example.worldtvgo.Model.TvShows.Cast;
import com.example.worldtvgo.Model.TvShows.TrailerItem;
import com.example.worldtvgo.R;
import com.example.worldtvgo.databinding.FragmentSynopsisBinding;
import com.example.worldtvgo.databinding.SynopsisDetailItemBinding;

import java.util.ArrayList;
import java.util.List;

public class SynopsisFragment extends Fragment {

    FragmentSynopsisBinding synopsisBinding;
    List<TrailerItem> trailerList;
    TrailerAdapter trailerAdapter;
    SynopsisDetailItemBinding synopsisDetailItemBinding;
    LinearLayoutManager mLayoutManager;
    List<Cast> cast;
    CastAdapter castAdapter;

    private boolean loading=true;

    private int pastVisibleItems,visibleItemCount,totalItemCount;

    Handler handler=new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        synopsisBinding=FragmentSynopsisBinding.inflate(getLayoutInflater());
        View view=synopsisBinding.getRoot();
         synopsisDetailItemBinding=SynopsisDetailItemBinding.bind(synopsisBinding.originalData.findViewById(R.id.synopsis_root));


        trailerList=new ArrayList<>();
        synopsisBinding.shimmerView.startShimmer();
        synopsisBinding.originalData.setVisibility(View.INVISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                synopsisBinding.shimmerView.setVisibility(View.INVISIBLE);
                synopsisBinding.shimmerView.stopShimmer();
                synopsisBinding.originalData.setVisibility(View.VISIBLE);
                synopsisDetailItemBinding.trailerRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                trailerAdapter=new TrailerAdapter(getContext(),trailerList,false);
                synopsisDetailItemBinding.trailerRecycler.setAdapter(trailerAdapter);
                populateData();
                populateCastDetail();



            }
        },5000);



        return view;
    }

    private void setPagination() {

        synopsisDetailItemBinding.trailerRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy>0){
                    visibleItemCount=mLayoutManager.getChildCount();
                    totalItemCount=mLayoutManager.getItemCount();
                    pastVisibleItems=mLayoutManager.findFirstVisibleItemPosition();

                    if(loading){
                        if((visibleItemCount+pastVisibleItems) >= totalItemCount){
                            loading=false;
                            Toast.makeText(getContext(), "This is last Item", Toast.LENGTH_LONG).show();
                            populateData();
                            trailerAdapter.notifyDataSetChanged();

                            loading=true;
                        }
                    }
                }
            }
        });
    }

    private   List<TrailerItem> populateData() {
        for (int i=0;i<20;i++){
            trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
        }


        return trailerList;

//        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));
//        trailerList.add(new TrailerItem("After witnessing Tanishaa Mukerji’s sizzling performance...","Preview",R.drawable.trailer_preview));



    }

    private List<Cast> populateCastDetail() {
        cast=new ArrayList<>();
        //set up cast recycler view
        synopsisDetailItemBinding.castRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        castAdapter=new CastAdapter(cast);
        synopsisDetailItemBinding.castRecycler.setAdapter(castAdapter);

        for (int i=0;i<20;i++){
            cast.add(new Cast(R.drawable.farah,"Farah Khan"));
        }


        return cast;


    }
}