package com.example.movieapplication.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface MoviesDao {
    @Insert
    void insertMovie(MoviesResult.ResultsBean resultsBean);
    @Query("select * from movie_table")
    List<MoviesResult.ResultsBean> getAllMovies();

}
