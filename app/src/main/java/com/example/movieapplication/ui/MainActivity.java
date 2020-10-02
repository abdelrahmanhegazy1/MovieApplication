package com.example.movieapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.MoviesResult;

public class MainActivity extends AppCompatActivity implements MovieInterface{
    TextView textView ;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        button=findViewById(R.id.button);

        final Preseneter preseneter= new Preseneter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preseneter.getData();
            }
        });
    }

    @Override
    public void onGetMovieDetail(MoviesResult moviesResult) {
        //set Data of Recycler View
        textView.setText(moviesResult.getResults().get(1).getTitle());

    }
}