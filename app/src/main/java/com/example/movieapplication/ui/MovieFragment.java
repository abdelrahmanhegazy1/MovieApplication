package com.example.movieapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.MovieDatabase;
import com.example.movieapplication.model.MoviesResult;
import com.example.movieapplication.ui.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment implements MovieSearchInterface {
    EditText searchText;
    RecyclerView recyclerView;
    Preseneter preseneter;
    List<MoviesResult.ResultsBean> movieList;
    MovieAdapter movieAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.movie_fragment,container,false);
        searchText=v.findViewById(R.id.searchtextMovie);
        recyclerView=v.findViewById(R.id.movieSearchRecycler);
        preseneter=new Preseneter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        movieList=new ArrayList<>();
        movieAdapter= new MovieAdapter(movieList,getContext());
        recyclerView.setAdapter(movieAdapter);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    if(!s.toString().equals(""))
                    {
                        preseneter.getMoviesFromSearch(s.toString());
                    }
                    else
                    {
                        movieList.clear();
                        movieAdapter.notifyDataSetChanged();
                    }
                }
                catch (Exception e)
                {
                    //Toast.makeText(getContext(), "K", Toast.LENGTH_SHORT).show();

                }


            }
        });

        movieAdapter.setOnItemClickListner(new MovieAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                Intent intent= new Intent(getContext(),MovieDetailActivity.class);
                intent.putExtra("movie",movieList.get(position));

                Pair<View,String> p1=Pair.create((View)imgContainer,"containterTN");
                Pair<View,String> p2=Pair.create((View)imgMovie,"movieTN");
                Pair<View,String> p3=Pair.create((View)movieTitle,"booktitleTN");
                Pair<View,String> p4=Pair.create((View)rating,"movieratinTN");
                Pair<View,String> p5=Pair.create((View)ratingBar,"movieratingbarTN");
                Pair<View,String> p6=Pair.create((View)releaseDate,"releasedateTN");

                ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(MovieFragment.super.getActivity(),p1,p2,p3,p4,p5,p6);
                startActivity(intent,optionsCompat.toBundle());
            }

            @Override
            public void onBookMarkClick(int position) {
                try{
                    MovieDatabase movieDatabase=MovieDatabase.getInstance(getContext());

                    movieDatabase.moviesDao().insertMovie(movieList.get(position));
                    Toast.makeText(getContext(), "book marked successfully", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e)
                {
                    Toast.makeText(getContext(), "You Added this Movie/TVShow before!", Toast.LENGTH_SHORT).show();


                }

            }
        });


        return v;
    }

    @Override
    public void onGetMoviesSearch(List<MoviesResult.ResultsBean> resultsBeans) {
        movieList.clear();
        movieList.addAll(resultsBeans);
        movieAdapter.notifyDataSetChanged();

    }
}
