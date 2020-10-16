package com.example.movieapplication.ui;

import android.content.Intent;
import android.graphics.Movie;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movieapplication.model.ActorResult;
import com.example.movieapplication.model.ApiInterface;
import com.example.movieapplication.model.MovieVideo;
import com.example.movieapplication.model.MoviesResult;
import com.example.movieapplication.model.RetrofitApi;
import com.example.movieapplication.model.TVShowResult;
import com.example.movieapplication.model.TVShowVideos;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Preseneter {
    MovieInterface movieInterface;
    public static String apiKey = "b76548ed051932a5868c47f677eb55e0";
    public static String language = "en-US";
    //public static String category = "popular";
    public static int page = 1;
    public MoviesResult moviesResult;
    public MovieVideo movieVideo;
    MovieResultInterfcae movieResultInterfcae;
    TVInterface tvInterface;
    public TVShowResult tvShowResult;
    public TVShowVideos tvShowVideos;
    public TVShowVideo tvShowVideo;
    ActorInterface actorInterface;
    MovieSearchInterface movieSearchInterface;
    TVSearchInterface tvSearchInterface;


    public Preseneter(MovieInterface movieInterface) {
        this.movieInterface = movieInterface;
    }
    public Preseneter(MovieResultInterfcae movieResultInterfcae){this.movieResultInterfcae=movieResultInterfcae;}
    public Preseneter(TVInterface tvInterface) {this.tvInterface=tvInterface;}
    public Preseneter(TVShowVideo tvShowVideo) {this.tvShowVideo=tvShowVideo;}
    public Preseneter(ActorInterface actorInterface) {this.actorInterface=actorInterface;}
    public Preseneter(MovieSearchInterface movieSearchInterface) {this.movieSearchInterface=movieSearchInterface;}
    public Preseneter(TVSearchInterface tvSearchInterface) {this.tvSearchInterface=tvSearchInterface;}



    public void getAllMovies(String category) {

        ApiInterface apiInterface=  RetrofitApi.getRetrofitApi().build_retrofit();
        Call<MoviesResult> call = apiInterface.getListMovies(category, apiKey, language, page);
        call.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                Log.e("bedo", "hello");
                moviesResult = response.body();
               // MainActivity.x = "mohamed";
                movieInterface.onGetMovieDetail(moviesResult);


            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                Log.e("body", "not hello");
                //MainActivity.x = "ahmed";
                // t.getMessage();
                t.printStackTrace();
            }
        });



    }

    public void getMovieVideo(int movie_id)
    {

        ApiInterface apiInterface= RetrofitApi.getRetrofitApi().build_retrofit();
        Call<MovieVideo> movieVideoCall= apiInterface.getMovieVideo(movie_id,apiKey,language,page);
        movieVideoCall.enqueue(new Callback<MovieVideo>() {
            @Override
            public void onResponse(Call<MovieVideo> call, Response<MovieVideo> response) {
                movieVideo=response.body();
                movieResultInterfcae.onGetMovieVideo(movieVideo.getResults().get(0).getKey());

            }

            @Override
            public void onFailure(Call<MovieVideo> call, Throwable t) {

            }
        });


    }

    public void getTVDetail(String category)
    {
        //TVShowResult tvShowResult;
        ApiInterface apiInterface= RetrofitApi.getRetrofitApi().build_retrofit();
        Call<TVShowResult> tvShowResultCall= apiInterface.getTVList(category,apiKey,language,page);
        tvShowResultCall.enqueue(new Callback<TVShowResult>() {
            @Override
            public void onResponse(Call<TVShowResult> call, Response<TVShowResult> response) {
                tvShowResult=response.body();
                tvInterface.onGetTVDetail(tvShowResult);
            }

            @Override
            public void onFailure(Call<TVShowResult> call, Throwable t) {

            }
        });


    }
    public void getTVShowVideo(int tvID)
    {
        ApiInterface apiInterface=RetrofitApi.getRetrofitApi().build_retrofit();
        Call<TVShowVideos> tvShowVideosCall= apiInterface.getTVShowVideo(tvID,apiKey,language,page);
        tvShowVideosCall.enqueue(new Callback<TVShowVideos>() {
            @Override
            public void onResponse(Call<TVShowVideos> call, Response<TVShowVideos> response) {
                tvShowVideos=response.body();
                tvShowVideo.onGetTVVideo(tvShowVideos.getResults().get(0).getKey());

            }

            @Override
            public void onFailure(Call<TVShowVideos> call, Throwable t) {

            }
        });

    }

    public void getActorData(String name)
    {
        ApiInterface apiInterface=RetrofitApi.getRetrofitApi().build_retrofit();
        Call<ActorResult> actorResultCall= apiInterface.getActors(name,apiKey,language,page);
        actorResultCall.enqueue(new Callback<ActorResult>() {
            @Override
            public void onResponse(Call<ActorResult> call, Response<ActorResult> response) {
                actorInterface.onGetActorData(response.body().getResults());
//                Log.d("bot", "onResponse: size"+response.body().getResults().get(0).getName());
            }

            @Override
            public void onFailure(Call<ActorResult> call, Throwable t) {
                Log.d("nno", "onFailure: fuck ");
            }
        });
    }
    public void getMoviesFromSearch(String name)
    {
        ApiInterface apiInterface=RetrofitApi.getRetrofitApi().build_retrofit();
        Call<MoviesResult> movieSearch= apiInterface.getMovieSearch(name,apiKey,language,page);
        movieSearch.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                movieSearchInterface.onGetMoviesSearch(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {

            }
        });

    }
    public void getTVFromSearch(String name)
    {
        ApiInterface apiInterface=RetrofitApi.getRetrofitApi().build_retrofit();
        Call<TVShowResult> tvShowResultCall=apiInterface.getTVSearch(name,apiKey,language,page);
        tvShowResultCall.enqueue(new Callback<TVShowResult>() {
            @Override
            public void onResponse(Call<TVShowResult> call, Response<TVShowResult> response) {
                tvSearchInterface.onGetTVSearch(response.body().getResults());
            }

            @Override
            public void onFailure(Call<TVShowResult> call, Throwable t) {

            }
        });

    }





}
