package com.example.movieapplication.ui;

import com.example.movieapplication.model.MoviesResult;

import java.util.List;

public interface MovieSearchInterface {
    public  void onGetMoviesSearch(List<MoviesResult.ResultsBean> resultsBeans);
}
