package com.example.movieapplication.ui.adapter;

import android.content.Context;
import android.media.Rating;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.ActorResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.ActorViewHolder> {

    public List<ActorResult.ResultsBean.KnownForBean> careerActor;
    Context context;
    private OnItemClickListner mListner;

    public CareerAdapter(List<ActorResult.ResultsBean.KnownForBean> careerActor, Context context) {
        this.careerActor = careerActor;
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
       return new ActorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details,parent,false),mListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
       // Log.d("king", "onBindViewHolder: "+careerActor.get(position).getName());
        holder.movieName.setText(careerActor.get(position).getTitle());

        Picasso.with(context).load("https://image.tmdb.org/t/p/w185/"+careerActor.get(position).getBackdrop_path())
                .into(holder.movieImage);
        holder.ratingBar.setRating((float)careerActor.get(position).getVote_average()/2);
        holder.rating.setText(String.valueOf(careerActor.get(position).getVote_average()/2));
        holder.releaseDate.setText(careerActor.get(position).getRelease_date());



    }

    @Override
    public int getItemCount() {
        return careerActor.size();
    }

    public static class ActorViewHolder extends RecyclerView.ViewHolder
    {
        ImageView movieImage;
        TextView movieName;
        TextView releaseDate;
        TextView rating;
        RatingBar ratingBar;
        ImageView imageView;
        public ActorViewHolder(@NonNull View itemView, OnItemClickListner listner) {
            super(itemView);
            movieImage=itemView.findViewById(R.id.movieImage);
            movieName=itemView.findViewById(R.id.movieName);
            releaseDate=itemView.findViewById(R.id.releaseDate);
            rating=itemView.findViewById(R.id.movieRating);
            ratingBar=itemView.findViewById(R.id.ratingBar);
            imageView=itemView.findViewById(R.id.imageView2);


        }
    }
}
