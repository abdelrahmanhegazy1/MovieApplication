package com.example.movieapplication.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.MoviesResult;
import com.example.movieapplication.model.TVShowResult;
import com.example.movieapplication.ui.adapter.MoviesHomeAdapter;
import com.example.movieapplication.ui.adapter.TVShowsHomeAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements MovieInterface ,TVInterface ,NavigationView.OnNavigationItemSelectedListener {
    ArrayList<String> categoryList;
    RecyclerView categoryRecyclerView;
    RecyclerView secondRecyclerView;
    MoviesHomeAdapter moviesHomeAdapter;
    Preseneter preseneter;
    Preseneter preseneter2;
    List<List<MoviesResult.ResultsBean>> allTypeMovies;
    List<List<TVShowResult.ResultsBean>> allTypeTVShows;
    TVShowsHomeAdapter tvShowsHomeAdapter;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Activity a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        categoryRecyclerView=findViewById(R.id.MoviesRecyclerviewHome);
        secondRecyclerView=findViewById(R.id.TVShowsRecyclerViewHome);
        categoryList= new ArrayList<>() ;
        preseneter= new Preseneter(this::onGetMovieDetail);
        preseneter2=new Preseneter(this::onGetTVDetail);
        allTypeMovies= new ArrayList<>();
        allTypeTVShows=new ArrayList<>();
        a=this;

        toolbar=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout2);
        navigationView= findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadData();

        //build_recycler();

    }



    private void loadData() {
        categoryList.add("popular");
        categoryList.add("upcoming");
        categoryList.add("top_rated");
        categoryList.add("top_rated");
        categoryList.add("popular");
        categoryList.add("on_the_air");

         tvShowsHomeAdapter= new TVShowsHomeAdapter(allTypeTVShows,this);
        for(int i=0;i<3;i++)
        {
            Log.d("A7A", "loadData: "+categoryList.get(i));
            preseneter.getAllMovies(categoryList.get(i));
        }
        moviesHomeAdapter= new MoviesHomeAdapter(allTypeMovies,this);

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerView.setAdapter(moviesHomeAdapter);
        for(int i=3;i<6;i++)
        {
            preseneter2.getTVDetail(categoryList.get(i));
        }
        tvShowsHomeAdapter= new TVShowsHomeAdapter(allTypeTVShows,this);
        secondRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        secondRecyclerView.setAdapter(tvShowsHomeAdapter);

        tvShowsHomeAdapter.setOnItemClickListner(new TVShowsHomeAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(TVShowResult.ResultsBean resultsBean, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                Intent intent= new Intent(getApplicationContext(),TVShowDetails.class);
                intent.putExtra("TV",resultsBean);

                Pair<View,String> p1=Pair.create((View)imgContainer,"containterTN");
                Pair<View,String> p2=Pair.create((View)imgMovie,"movieTN");
                Pair<View,String> p3=Pair.create((View)movieTitle,"booktitleTN");
                Pair<View,String> p4=Pair.create((View)rating,"movieratinTN");
                Pair<View,String> p5=Pair.create((View)ratingBar,"movieratingbarTN");
                Pair<View,String> p6=Pair.create((View)releaseDate,"releasedateTN");

                Log.d("xxx", "onItemClick: bttklm begad?");
                ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(a,p1,p2,p3,p4,p5,p6);
                startActivity(intent,optionsCompat.toBundle());
            }
        });
        moviesHomeAdapter.setOnItemClickListner(new MoviesHomeAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(MoviesResult.ResultsBean resultsBean, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                Intent intent= new Intent(getApplicationContext(),MovieDetailActivity.class);
                intent.putExtra("movie",resultsBean);

                Pair<View,String> p1=Pair.create((View)imgContainer,"containterTN");
                Pair<View,String> p2=Pair.create((View)imgMovie,"movieTN");
                Pair<View,String> p3=Pair.create((View)movieTitle,"booktitleTN");
                Pair<View,String> p4=Pair.create((View)rating,"movieratinTN");
                Pair<View,String> p5=Pair.create((View)ratingBar,"movieratingbarTN");
                Pair<View,String> p6=Pair.create((View)releaseDate,"releasedateTN");

                Log.d("xxx", "onItemClick: bttklm begad?");
                ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(a,p1,p2,p3,p4,p5,p6);
                startActivity(intent,optionsCompat.toBundle());
            }
        });

    }

    @Override
    public void onGetMovieDetail(MoviesResult moviesResult) {

        allTypeMovies.add(moviesResult.getResults());
        Log.d("kosomok", "onGetMovieDetail: "+allTypeMovies.size());

        moviesHomeAdapter.notifyDataSetChanged();
        //moviesHomeAdapter.notifyAll();
    }

    @Override
    public void onGetTVDetail(TVShowResult tvShowResult) {
        allTypeTVShows.add(tvShowResult.getResults());
        tvShowsHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Home :
            break;

            case R.id.tvSeries:
            {
                Intent intent= new Intent(getApplicationContext(),TVShowActivity.class);
                startActivity(intent);

            }
            break;
            case R.id.popular:
            {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
                break;
            case R.id.wishlist:
            {
                Intent intent=new Intent(getApplicationContext(),WishlistActivity.class);
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