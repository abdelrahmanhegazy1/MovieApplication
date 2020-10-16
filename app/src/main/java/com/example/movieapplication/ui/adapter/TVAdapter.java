package com.example.movieapplication.ui.adapter;

import android.content.Context;
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
import com.example.movieapplication.model.TVShowResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TVViewHolder> {

    List<TVShowResult.ResultsBean> tvShowResults;
    Context context;
    private TVAdapter.OnItemClickListner mListner;
    public interface  OnItemClickListner
    {
        void onItemClick(int position,
                         ImageView imgMovie,
                         ImageView imgContainer,
                         TextView movieTitle,
                         TextView rating ,
                         RatingBar ratingBar,
                         TextView releaseDate);

    }
    public void setOnItemClickListner(TVAdapter.OnItemClickListner listner)
    {
        mListner=listner;
    }

    public TVAdapter(List<TVShowResult.ResultsBean> tvShowResults, Context context) {
        this.tvShowResults = tvShowResults;
        this.context = context;
    }

    @NonNull
    @Override
    public TVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new TVViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details,parent,false),mListner);
    }

    @Override
    public void onBindViewHolder(@NonNull TVViewHolder holder, int position) {
        Picasso.with(context).load("https://image.tmdb.org/t/p/w185"+"/"+tvShowResults.get(position).getPoster_path()).into(holder.movieImage);
        holder.movieTitle.setText(tvShowResults.get(position).getOriginal_name());
        holder.rateOfMovie.setText(String.valueOf(tvShowResults.get(position).getVote_average()/2)+"Rating");
        holder.ratingBar.setRating((float)(tvShowResults.get(position).getVote_average()/2));
        holder.releaseDate.setText("Release Date: "+tvShowResults.get(position).getFirst_air_date());
    }

    @Override
    public int getItemCount() {
        return tvShowResults.size();
    }

    public static class TVViewHolder extends RecyclerView.ViewHolder
    {
        ImageView movieImage;
        ImageView movieContainer;
        TextView movieTitle;
       // TextView someDetail;
        TextView rateOfMovie;
        RatingBar ratingBar;
        TextView releaseDate;

        public TVViewHolder(@NonNull View itemView, TVAdapter.OnItemClickListner tvlistner) {
            super(itemView);
            movieImage= itemView.findViewById(R.id.movieImage);
            movieTitle=itemView.findViewById(R.id.movieName);
            //  someDetail=itemView.findViewById(R.id.movieDesc);
            rateOfMovie=itemView.findViewById(R.id.movieRating);
            ratingBar= itemView.findViewById(R.id.ratingBar);
            releaseDate=itemView.findViewById(R.id.releaseDate);
            movieContainer=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(tvlistner!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            Log.d("assa", "onClick: position= "+position+" and imageview "+R.id.imageView);


                            tvlistner.onItemClick(position,movieImage,movieContainer,movieTitle,rateOfMovie,ratingBar,releaseDate);
                        }
                    }

                }
            });
        }
    }

}
