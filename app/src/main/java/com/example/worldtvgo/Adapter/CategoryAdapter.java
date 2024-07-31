package com.example.worldtvgo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.Model.Category;
import com.example.worldtvgo.Model.GenreItem;
import com.example.worldtvgo.Model.InnerItem;
import com.example.worldtvgo.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<Category> categoryName;
    Context context;

    public CategoryAdapter(List<Category> categoryName,Context context) {
        this.categoryName = categoryName;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category=categoryName.get(position);
        holder.categoryName.setText(category.getName());

        List<InnerItem> innerItems=(List<InnerItem>)(List<?>) category.getItems() ;
        InnerAdapter innerAdapter=new InnerAdapter(innerItems,context);
        holder.innerRecyclerView.setAdapter(innerAdapter);
        holder.innerRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));


    }

    @Override
    public int getItemCount() {
        return categoryName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView arrowImage;
        RecyclerView innerRecyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=(TextView) itemView.findViewById(R.id.category_text);
            arrowImage=(ImageView) itemView.findViewById(R.id.right_arrow);
            innerRecyclerView=(RecyclerView) itemView.findViewById(R.id.recycler_view_for_inside);
        }
    }
}