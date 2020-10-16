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
import com.example.movieapplication.model.MoviesResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    public boolean flag=false;
    List<MoviesResult.ResultsBean> resultsMovie;
    private Context context;
    private OnItemClickListner mListner;
    public interface  OnItemClickListner
    {
        void onItemClick(int position,
                         ImageView imgMovie,
                         ImageView imgContainer,
                         TextView movieTitle,
                         TextView rating ,
                         RatingBar ratingBar,
                         TextView releaseDate);
        void onBookMarkClick(int position);

    }

    public MovieAdapter(List<MoviesResult.ResultsBean> resultsMovie,Context context) {
        this.resultsMovie = resultsMovie;
        this.context=context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details,parent,false),mListner);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Picasso.with(context).load("https://image.tmdb.org/t/p/w185"+"/"+resultsMovie.get(position).getPoster_path()).into(holder.movieImage);
        holder.movieTitle.setText(resultsMovie.get(position).getTitle());
       // Glide.with(context).load("https://image.tmdb.org/t/p/w185"+"/"+resultsMovie.get(position).getPoster_path()).transform(new CenterCrop(),new RoundedCorners(16)).into(holder.movieImage);
       // holder.someDetail.setText(resultsMovie.get(position).getOverview());
        holder.rateOfMovie.setText(String.valueOf(resultsMovie.get(position).getVote_average()/2)+"Rating");
        holder.ratingBar.setRating((float)(resultsMovie.get(position).getVote_average()/2));
        holder.releaseDate.setText("Release Date: "+resultsMovie.get(position).getRelease_date());

        if(flag)
        {
            holder.bookMark.setImageResource(R.drawable.ic_baseline_done_24);
           // flag=false;
        }



    }

    @Override
    public int getItemCount() {
        return resultsMovie.size();
    }
    public void setOnItemClickListner(OnItemClickListner listner)
    {
        mListner=listner;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        ImageView movieContainer;
        TextView movieTitle;
        TextView someDetail;
        TextView rateOfMovie;
        RatingBar ratingBar;
        TextView releaseDate;
        ImageView bookMark;
        public MovieViewHolder(@NonNull View itemView ,OnItemClickListner movieListner) {
            super(itemView);
            movieImage= itemView.findViewById(R.id.movieImage);
             movieTitle=itemView.findViewById(R.id.movieName);
           //  someDetail=itemView.findViewById(R.id.movieDesc);
             rateOfMovie=itemView.findViewById(R.id.movieRating);
             ratingBar= itemView.findViewById(R.id.ratingBar);
             releaseDate=itemView.findViewById(R.id.releaseDate);
             movieContainer=itemView.findViewById(R.id.imageView);
             bookMark=itemView.findViewById(R.id.imageView2);

             bookMark.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(movieListner!=null)
                     {
                         int position=getAdapterPosition();
                         if(position!=RecyclerView.NO_POSITION)
                         {
                             movieListner.onBookMarkClick(position);
                             bookMark.setImageResource(R.drawable.ic_baseline_done_24);

                         }
                     }

                 }
             });


             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(movieListner!=null)
                     {
                         int position=getAdapterPosition();
                         if(position!=RecyclerView.NO_POSITION)
                         {
                             Log.d("assa", "onClick: position= "+position+" and imageview "+R.id.imageView);
                             movieListner.onItemClick(position,movieImage,movieContainer,movieTitle,rateOfMovie,ratingBar,releaseDate);
                         }
                     }

                 }
             });
        }
    }
}
