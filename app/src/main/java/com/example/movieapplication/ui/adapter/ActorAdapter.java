package com.example.movieapplication.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.ActorResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    public List<ActorResult.ResultsBean> actorsResults;
    Context context;
    private OnItemClickListner mListner;

    public ActorAdapter(List<ActorResult.ResultsBean> actorsResults, Context context) {
        this.actorsResults = actorsResults;
        this.context = context;
    }
    public interface OnItemClickListner {
        void onItemClick(int position);
    }
    public void setOnItemClickListner(OnItemClickListner listner)
    {
        mListner=listner;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ActorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_card,parent,false),mListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        Log.d("king", "onBindViewHolder: "+actorsResults.get(position).getName());
        holder.actorName.setText(actorsResults.get(position).getName());
        Picasso.with(context).load("https://image.tmdb.org/t/p/w185/"+actorsResults.get(position).getProfile_path())
                .into(holder.actorImage);
        holder.popularity.setText(String.valueOf(actorsResults.get(position).getPopularity()));

    }

    @Override
    public int getItemCount() {
        return actorsResults.size();
    }

    public static class ActorViewHolder extends RecyclerView.ViewHolder
    {
        ImageView actorImage;
        TextView actorName;
        TextView popularity;
        public ActorViewHolder(@NonNull View itemView, OnItemClickListner listner) {
            super(itemView);
            actorImage=itemView.findViewById(R.id.actorImage);
            actorName=itemView.findViewById(R.id.actorName);
            popularity=itemView.findViewById(R.id.popularity);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(getAdapterPosition());
                }
            });


        }
    }
}
