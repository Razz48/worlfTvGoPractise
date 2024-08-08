package com.example.worldtvgo.Adapter.TvShows;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.Model.TvShows.Cast;
import com.example.worldtvgo.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.ViewHolder> {

    List<Cast> cast;

    public CastAdapter(List<Cast> cast) {
        this.cast = cast;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cast castdetail=cast.get(position);
        holder.castImage.setImageResource(castdetail.getImage());
        holder.castName.setText(castdetail.getName());

    }

    @Override
    public int getItemCount() {
        return cast.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView castImage;
        TextView castName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            castImage=(CircleImageView) itemView.findViewById(R.id.cast_img);
            castName=(TextView) itemView.findViewById(R.id.cast_name);
        }
    }
}
