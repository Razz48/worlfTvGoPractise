package com.example.worldtvgo;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.worldtvgo.Adapter.CategoryAdapter;
import com.example.worldtvgo.Model.Category;
import com.example.worldtvgo.Model.InnerItem;
import com.example.worldtvgo.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding homeBinding;
    List<Category> categoryName;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        View view=homeBinding.getRoot();
        setContentView(view);
//        setContentView(R.layout.activity_home);

        categoryName=new ArrayList<>();
        categoryName.add(new Category("Featured", Arrays.asList(
                new InnerItem(R.drawable.image_recycler, R.drawable.image_small_recycler, R.drawable.youtbe_icon,
                        "English", "Playing", "Next | Onward 2020 Animation", R.drawable.youtbe_icon, "Sony Entertainment", 1221),
                new InnerItem(R.drawable.image_recycler, R.drawable.image_small_recycler, R.drawable.youtbe_icon,
                        "English", "Playing", "Next | Onward 2020 Animation", R.drawable.youtbe_icon, "Sony Entertainment", 1222),
                new InnerItem(R.drawable.image_recycler, R.drawable.image_small_recycler, R.drawable.youtbe_icon,
                        "English", "Playing", "Next | Onward 2020 Animation", R.drawable.youtbe_icon, "Sony Entertainment", 1223),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221)
        )));
        categoryName.add(new Category("Continue Watching",Arrays.asList(new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221))));


        categoryName.add(new Category("Entertainment",Arrays.asList(new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221))));


        categoryName.add(new Category("Thriller",Arrays.asList(new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221),
                new InnerItem(R.drawable.image_recycler,R.drawable.image_small_recycler,R.drawable.youtbe_icon,
                        "English","Playing","Next | Onward 2020 Animation",R.drawable.sony_tv_logo,"Sony EntertainMent",1221))));
        setCategory();

    }


    private void setCategory(){

        categoryAdapter=new CategoryAdapter(categoryName,getApplicationContext());
        homeBinding.categoryRecycler.setAdapter(categoryAdapter);
//        homeBinding.categoryRecycler.setNestedScrollingEnabled(false);
        homeBinding.categoryRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}



//@Override
//public boolean canScrollVertically() {
//    return false;
//}
//        }