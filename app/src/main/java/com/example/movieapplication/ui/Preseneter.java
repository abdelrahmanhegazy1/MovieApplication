package com.example.movieapplication.ui;

import android.util.Log;

import com.example.movieapplication.model.ApiInterface;
import com.example.movieapplication.model.MoviesResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Preseneter {
MovieInterface movieInterface;
public static  String apiKey="b76548ed051932a5868c47f677eb55e0";
public static String language="en-US";
public static String category="popular";
public static int page=1;
public MoviesResult moviesResult;


    public Preseneter(MovieInterface movieInterface) {
        this.movieInterface = movieInterface;
    }

    public MoviesResult getAllMovies()
    {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface= retrofit.create(ApiInterface.class);

        Call<MoviesResult> call= apiInterface.getListMovies(category,apiKey,language,page);
        call.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                moviesResult=response.body();
                Log.e("bedo", "hello");
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {

                Log.e("body", "not hello");
               // t.getMessage();
                t.printStackTrace();
            }
        });

        return moviesResult;
    }

    public void getData()
    {
        movieInterface.onGetMovieDetail(getAllMovies());
    }
    

}
