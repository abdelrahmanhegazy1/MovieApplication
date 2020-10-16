package com.example.movieapplication.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.MovieDatabase;
import com.example.movieapplication.model.MoviesResult;
import com.example.movieapplication.ui.Preseneter;

import java.util.List;

public class MoviesHomeAdapter extends RecyclerView.Adapter<MoviesHomeAdapter.CategoryViewHolder> {
    //public List<String> categoryNames;
    Context context;
    List<List<MoviesResult.ResultsBean>> allTypeMovies;
    private MoviesHomeAdapter.OnItemClickListner mListner;
    public MovieAdapter mAdapter[]= new MovieAdapter[3];
    int i=0;
    public interface  OnItemClickListner
    {
        void onItemClick(MoviesResult.ResultsBean resultsBean, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate);

    }
    public void setOnItemClickListner(MoviesHomeAdapter.OnItemClickListner listner)
    {
        mListner=listner;
    }


    public MoviesHomeAdapter(List<List<MoviesResult.ResultsBean>> allTypeMovies, Context context) {
        this.allTypeMovies = allTypeMovies;
        this.context = context;

    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_home,parent,false),mListner,mAdapter);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
         mAdapter[i]= new MovieAdapter(allTypeMovies.get(position),context);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter( mAdapter[i]);
        mAdapter[i].setOnItemClickListner(new MovieAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int positionX, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                Log.d("hegoz", "onItemClick: sssssssss "+position+" "+positionX);
                MoviesResult.ResultsBean finalResult= allTypeMovies.get(position).get(positionX);
                mListner.onItemClick(finalResult,imgMovie,imgContainer,movieTitle,rating,ratingBar,releaseDate);

            }

            @Override
            public void onBookMarkClick(int positionX) {
                try{
                    MovieDatabase movieDatabase=MovieDatabase.getInstance(context);
                    movieDatabase.moviesDao().insertMovie(allTypeMovies.get(position).get(positionX));
                    Toast.makeText(context, "book marked successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(context, "You Added this Movie/TVShow before!", Toast.LENGTH_SHORT).show();
                }

            }

        });

        if(position==0)
        {
            i=1;
            holder.categoryName.setText("Popular Movies");
        }
        else if(position==1)
        {
            i=2;
            holder.categoryName.setText("UPComing Movies");
        }
        else
        {
            holder.categoryName.setText("Top Rated Movies");

        }
    }

    @Override
    public int getItemCount() {
        return allTypeMovies.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder
    {

        RecyclerView recyclerView;
        TextView categoryName;

        public CategoryViewHolder(@NonNull View itemView, OnItemClickListner categoryListner,MovieAdapter []mAdapter) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.homeMovies);
            categoryName=itemView.findViewById(R.id.popular);

            if(getAdapterPosition()!=RecyclerView.NO_POSITION)
            {
                Log.d("fely", "CategoryViewHolder: a7a ");


            }





            
        }


    }
}
