package com.example.movieapplication.model;

import android.util.Log;

import com.example.movieapplication.ui.MainActivity;
import com.example.movieapplication.ui.MovieInterface;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    public static String apiKey = "b76548ed051932a5868c47f677eb55e0";
    public static String language = "en-US";
    public static String category = "popular";
    public static int page = 1;
    public static RetrofitApi retrofitApi=null;
    public static MoviesResult moviesResult;
    public static MovieInterface movieInterface;

    public static RetrofitApi getRetrofitApi() {
        if(retrofitApi==null)
            retrofitApi= new RetrofitApi();
        return retrofitApi;
    }
    private RetrofitApi() {}

    public ApiInterface build_retrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;

        /*
        Call<MoviesResult> call = apiInterface.getListMovies(category, apiKey, language, page);
        call.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                Log.e("bedo", "hello");
                moviesResult = response.body();
                MainActivity.x = "mohamed";
                movieInterface.onGetMovieDetail(moviesResult);



            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                Log.e("body", "not hello");
                MainActivity.x = "ahmed";
                // t.getMessage();
                t.printStackTrace();
            }
        });
        */

    }
}
