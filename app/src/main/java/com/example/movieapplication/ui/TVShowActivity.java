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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.TVShowResult;
import com.example.movieapplication.ui.adapter.TVAdapter;
import com.google.android.material.navigation.NavigationView;

public class TVShowActivity extends AppCompatActivity implements TVInterface , NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    TVAdapter tvAdapter;
    Preseneter preseneter;
    Activity a;
    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_show);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        recyclerView=findViewById(R.id.recyclerViewTV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        preseneter= new Preseneter(this);
        preseneter.getTVDetail("popular");
        a=this;


    }

    @Override
    public void onGetTVDetail(TVShowResult tvShowResult) {
        tvAdapter= new TVAdapter(tvShowResult.getResults(),this);
        recyclerView.setAdapter(tvAdapter);
        tvAdapter.setOnItemClickListner(new TVAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                Intent intent= new Intent(getBaseContext(),TVShowDetails.class);
                intent.putExtra("TV",preseneter.tvShowResult.getResults().get(position));

                Pair<View,String> p1=Pair.create((View)imgContainer,"containterTN");
                Pair<View,String> p2=Pair.create((View)imgMovie,"movieTN");
                Pair<View,String> p3=Pair.create((View)movieTitle,"booktitleTN");
                Pair<View,String> p4=Pair.create((View)rating,"movieratinTN");
                Pair<View,String> p5=Pair.create((View)ratingBar,"movieratingbarTN");
                Pair<View,String> p6=Pair.create((View)releaseDate,"releasedateTN");


                ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(a,p1,p2,p3,p4,p5,p6);
                startActivity(intent,optionsCompat.toBundle());
            }
        });


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

            break;
            case R.id.popular:
            {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
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