package com.example.movieapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieapplication.R;
import androidx.core.util.Pair;

import com.example.movieapplication.model.MovieDatabase;
import com.example.movieapplication.model.MoviesResult;
import com.example.movieapplication.ui.adapter.MovieAdapter;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements MovieInterface, NavigationView.OnNavigationItemSelectedListener {
    TextView textView ;
    Button button;
    MovieAdapter movieAdapter;
    RecyclerView recyclerView;
     Preseneter preseneter;
     Activity a;
     Toolbar toolbar;
     private DrawerLayout drawerLayout;
     NavigationView navigationView;


    //public  static  String x= "sx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView=findViewById(R.id.textview);
        //button=findViewById(R.id.button);
        recyclerView=findViewById(R.id.recyclerView);
        a=this;

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();




         preseneter= new Preseneter(this);
        preseneter.getAllMovies("popular");

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        super.onBackPressed();
    }

    @Override
    public void onGetMovieDetail(MoviesResult moviesResult) {
        //set Data of Recycler View
        //textView.setText(moviesResult.getResults().get(1).getTitle());
        movieAdapter= new MovieAdapter(moviesResult.getResults(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.setOnItemClickListner(new MovieAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                Intent intent= new Intent(getApplicationContext(),MovieDetailActivity.class);
                intent.putExtra("movie",preseneter.moviesResult.getResults().get(position));

                Pair<View,String> p1=Pair.create((View)imgContainer,"containterTN");
                Pair<View,String> p2=Pair.create((View)imgMovie,"movieTN");
                Pair<View,String> p3=Pair.create((View)movieTitle,"booktitleTN");
                Pair<View,String> p4=Pair.create((View)rating,"movieratinTN");
                Pair<View,String> p5=Pair.create((View)ratingBar,"movieratingbarTN");
                Pair<View,String> p6=Pair.create((View)releaseDate,"releasedateTN");


                ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(a,p1,p2,p3,p4,p5,p6);
                startActivity(intent,optionsCompat.toBundle());
            }

            @Override
            public void onBookMarkClick(int position) {
                try{
                    MovieDatabase movieDatabase=MovieDatabase.getInstance(getApplicationContext());

                    movieDatabase.moviesDao().insertMovie(preseneter.moviesResult.getResults().get(position));
                    Toast.makeText(getApplicationContext(), "book marked successfully", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "You Added this Movie/TVShow before!", Toast.LENGTH_SHORT).show();


                }


            }
        });



    }




    public void onBookItemClicked(int pos, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
        Intent intent= new Intent(getApplicationContext(),MovieDetailActivity.class);
        intent.putExtra("movi",preseneter.moviesResult.getResults().get(pos));

        Pair<View,String> p1=Pair.create((View)imgContainer,"containterTN");
        Pair<View,String> p2=Pair.create((View)imgMovie,"movieTN");
        Pair<View,String> p3=Pair.create((View)movieTitle,"booktitleTN");
        Pair<View,String> p4=Pair.create((View)rating,"movieratinTN");
        Pair<View,String> p5=Pair.create((View)ratingBar,"movieratingbarTN");
        Pair<View,String> p6=Pair.create((View)releaseDate,"releasedateTN");

        ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2,p3,p4,p5,p6);
        startActivity(intent,optionsCompat.toBundle());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Home :
            {
                Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);

            }
            break;

            case R.id.tvSeries:
            {
                Intent intent= new Intent(getApplicationContext(),TVShowActivity.class);
                startActivity(intent);

            }
            break;
            case R.id.popular:
                break;
            case R.id.wishlist:
            {
                Intent intent= new Intent(getApplicationContext(),WishlistActivity.class);
                startActivity(intent);

            }

                break;
            case R.id.search:
            {
                Intent intent= new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent);

            }
            break;



        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}