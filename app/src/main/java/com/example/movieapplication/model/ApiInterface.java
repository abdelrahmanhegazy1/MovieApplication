package com.example.movieapplication.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/3/movie/{category}")
    Call<MoviesResult> getListMovies(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page

    );
    @GET("/3/movie/{movie_id}/videos")
    Call<MovieVideo> getMovieVideo(
            @Path("movie_id") int movie_id,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
    @GET("/3/tv/{category}")
    Call<TVShowResult> getTVList(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page

    );

    @GET("/3/tv/{tv_id}/videos")
    Call<TVShowVideos> getTVShowVideo(
            @Path("tv_id") int tv_id,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
    @GET("/3/search/person")
    Call<ActorResult> getActors(
            @Query("query") String actorName,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page

    );
    @GET("/3/search/movie")
    Call<MoviesResult> getMovieSearch (
            @Query("query") String movieName,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
    @GET("/3/search/tv")
    Call<TVShowResult> getTVSearch (
            @Query("query") String tvName,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );


}
