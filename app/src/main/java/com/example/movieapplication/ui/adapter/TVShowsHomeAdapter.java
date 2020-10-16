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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.MoviesResult;
import com.example.movieapplication.model.TVShowResult;
import com.example.movieapplication.ui.MainActivity;
import com.example.movieapplication.ui.Preseneter;

import java.util.List;

public class TVShowsHomeAdapter extends RecyclerView.Adapter<TVShowsHomeAdapter.TVShowHomeViewHolder> {
    List<List<TVShowResult.ResultsBean>> allTypeTV;
    Context context;
    public TVAdapter tvAdapter[]= new TVAdapter[3];
    private TVShowsHomeAdapter.OnItemClickListner mListner;
    int i=0;
    public interface  OnItemClickListner
    {
        void onItemClick(TVShowResult.ResultsBean resultsBean, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate);

    }
    public void setOnItemClickListner(TVShowsHomeAdapter.OnItemClickListner listner)
    {
        mListner=listner;
    }

    public TVShowsHomeAdapter(List<List<TVShowResult.ResultsBean>> allTypeMovies, Context context) {
        this.allTypeTV = allTypeMovies;
        this.context = context;
    }

    @NonNull
    @Override
    public TVShowHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new TVShowHomeViewHolder(LayoutInflater.from
                (parent.getContext()).inflate(R.layout.movies_home,parent,false),mListner);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowHomeViewHolder holder, int position) {
        tvAdapter[i]= new TVAdapter(allTypeTV.get(position),context);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(tvAdapter[i]);
        tvAdapter[i].setOnItemClickListner(new TVAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int positionX, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                TVShowResult.ResultsBean resultsBean= allTypeTV.get(position).get(positionX);
                Log.d("TAG", "onItemClick: "+position+" "+positionX);
                mListner.onItemClick(resultsBean,imgMovie,imgContainer,movieTitle,rating,ratingBar,releaseDate);
            }
        });

        if(position==0)
        {
            i=1;
            holder.categoryName.setText("Top Rated TVSHOW");
        }
        else if(position==1)
        {   i=2;
            holder.categoryName.setText("Popular TVSHOW");
        }
        else
        {
            holder.categoryName.setText("On The Air TVSHOW");

        }
    }

    @Override
    public int getItemCount() {
        return allTypeTV.size();
    }

    public static class TVShowHomeViewHolder extends RecyclerView.ViewHolder
    {
            RecyclerView recyclerView;
            TextView categoryName;

        public TVShowHomeViewHolder(@NonNull View itemView,OnItemClickListner listner) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.homeMovies);
            categoryName=itemView.findViewById(R.id.popular);
        }

    }
}
