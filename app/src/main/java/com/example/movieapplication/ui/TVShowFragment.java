package com.example.movieapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.MoviesResult;
import com.example.movieapplication.model.TVShowResult;
import com.example.movieapplication.ui.adapter.MovieAdapter;
import com.example.movieapplication.ui.adapter.TVAdapter;

import java.util.ArrayList;
import java.util.List;

public class TVShowFragment extends Fragment implements TVSearchInterface{
    EditText searchText;
    RecyclerView recyclerView;
    Preseneter preseneter;
    List<TVShowResult.ResultsBean> tvList;
    TVAdapter tvAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.tvshow_fragment,container,false);
        searchText=v.findViewById(R.id.searchtextTVShow);
        recyclerView=v.findViewById(R.id.tvsearchRecycler);
        preseneter=new Preseneter(this);
        tvList= new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tvAdapter=new TVAdapter(tvList,getContext());
        recyclerView.setAdapter(tvAdapter);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    if(!s.toString().equals(""))
                    {
                        preseneter.getTVFromSearch(s.toString());
                    }
                    else
                    {
                        tvList.clear();
                        tvAdapter.notifyDataSetChanged();
                    }
                }
                catch (Exception e)
                {
                    //Toast.makeText(getContext(), "K", Toast.LENGTH_SHORT).show();

                }
            }
        });
        tvAdapter.setOnItemClickListner(new TVAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position, ImageView imgMovie, ImageView imgContainer, TextView movieTitle, TextView rating, RatingBar ratingBar, TextView releaseDate) {
                Intent intent= new Intent(getContext(),TVShowDetails.class);
                intent.putExtra("TV",tvList.get(position));

                Pair<View,String> p1=Pair.create((View)imgContainer,"containterTN");
                Pair<View,String> p2=Pair.create((View)imgMovie,"movieTN");
                Pair<View,String> p3=Pair.create((View)movieTitle,"booktitleTN");
                Pair<View,String> p4=Pair.create((View)rating,"movieratinTN");
                Pair<View,String> p5=Pair.create((View)ratingBar,"movieratingbarTN");
                Pair<View,String> p6=Pair.create((View)releaseDate,"releasedateTN");


                ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(TVShowFragment.super.getActivity(),p1,p2,p3,p4,p5,p6);
                startActivity(intent,optionsCompat.toBundle());
            }
        });



        return v;
    }


    @Override
    public void onGetTVSearch(List<TVShowResult.ResultsBean> resultsBeans) {
        tvList.clear();
        tvList.addAll(resultsBeans);
        tvAdapter.notifyDataSetChanged();
    }
}
