package com.example.movieapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.ActorResult;
import com.example.movieapplication.ui.adapter.CareerAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.Picasso;

public class ActorDetail extends AppCompatActivity {
    RecyclerView recyclerView;
    CareerAdapter careerAdapter;
    ActorResult.ResultsBean actor;
    BottomSheetBehavior bottomSheetBehavior;
    TextView actorName;
    ImageView actorImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);
        actorName=findViewById(R.id.actorname);
        actorImage=findViewById(R.id.actorphoto);
        recyclerView=findViewById(R.id.rec_career);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        actor=(ActorResult.ResultsBean)getIntent().getExtras().getSerializable("actor");
        actorName.setText(actor.getName());
        Picasso.with(this).load("https://image.tmdb.org/t/p/w185/"+actor.getProfile_path()).into(actorImage);

        careerAdapter= new CareerAdapter(actor.getKnown_for(),this);
        recyclerView.setAdapter(careerAdapter);


    }
}