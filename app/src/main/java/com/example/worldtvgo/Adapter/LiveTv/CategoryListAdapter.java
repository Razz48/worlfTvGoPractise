package com.example.worldtvgo.Adapter.LiveTv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.R;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {


    private final List<String> categories;
    private final OnCategoryClickListner listner;

    private int selectedPosition=RecyclerView.NO_POSITION;


    public CategoryListAdapter(List<String> categories, OnCategoryClickListner listner) {
        this.categories = categories;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String category = categories.get(position);
        holder.bind(category, position == selectedPosition);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = (TextView) itemView.findViewById(R.id.category_txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION ) {
                        notifyItemChanged(selectedPosition);
                        selectedPosition=position;
                        notifyItemChanged(selectedPosition);
                        listner.onCategoryClick(categories.get(position));
                    }
                }
            });
        }

        public void bind(String category, boolean isSelected) {
            categoryName.setText(category);
            itemView.setSelected(isSelected);
        }
    }

    public interface OnCategoryClickListner{
        void onCategoryClick(String categoty);
    }
}
