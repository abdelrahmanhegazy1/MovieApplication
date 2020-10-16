package com.example.movieapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movieapplication.R;
import com.example.movieapplication.YoutubeConfig;
import com.example.movieapplication.model.MoviesResult;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends  YouTubeBaseActivity implements MovieResultInterfcae {
    ImageView movieImage;
    TextView movieTitle;
    TextView movieDesc;
    TextView releaseDate;
    TextView movieRating;
    RatingBar ratingBar;
    MoviesResult.ResultsBean resultsBean;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    Button btnPlay;
    YouTubePlayerView mYouTubePlayerView;
    Preseneter preseneter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preseneter= new Preseneter(this);
        setContentView(R.layout.activity_movie_detail);
         resultsBean=(MoviesResult.ResultsBean)getIntent().getExtras().getSerializable("movie");
        movieImage=findViewById(R.id.movieImage1);
        movieDesc=findViewById(R.id.movieDesc);
        movieRating=findViewById(R.id.movieRating1);
        movieTitle=findViewById(R.id.movieName1);
        releaseDate=findViewById(R.id.releaseDate1);
        ratingBar=findViewById(R.id.ratingBar1);
       // btnPlay=findViewById(R.id.button);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.view);
        preseneter.getMovieVideo(resultsBean.getId());



        loadData();
    }

    private void loadData() {
        Picasso.with(this).load("https://image.tmdb.org/t/p/w185"+"/"+resultsBean.getPoster_path()).into(movieImage);
        movieTitle.setText(resultsBean.getTitle());
        movieRating.setText(String.valueOf(resultsBean.getVote_average()/2));
        ratingBar.setRating((float)resultsBean.getVote_average()/2);
        movieDesc.setText(resultsBean.getOverview());
        releaseDate.setText(resultsBean.getRelease_date());

    }

    @Override
    public void onGetMovieVideo(String keyVideo) {


        mOnInitializedListener= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(keyVideo);
                Log.d("bedany", "onInitializationSuccess:  "+keyVideo);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("bedany", "onInitializationFailed:  "+youTubeInitializationResult);
            }
        };
        mYouTubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);



    }
}