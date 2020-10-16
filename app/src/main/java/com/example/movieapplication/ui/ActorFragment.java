package com.example.movieapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplication.R;
import com.example.movieapplication.model.ActorResult;
import com.example.movieapplication.ui.adapter.ActorAdapter;
import com.example.movieapplication.ui.adapter.CareerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActorFragment extends Fragment implements ActorInterface {
    EditText searchText;
    RecyclerView recyclerView;
    Preseneter preseneter;
    ActorAdapter actorAdapter;
    List<ActorResult.ResultsBean> actorsResult;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.people_fragment,container,false);
        searchText=v.findViewById(R.id.searchtextActor);
        recyclerView=v.findViewById(R.id.pepsearchRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        actorsResult= new ArrayList<>();
        actorAdapter= new ActorAdapter(actorsResult,getContext());
        recyclerView.setAdapter(actorAdapter);
        preseneter= new Preseneter(this);

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               try {
                   if(!s.toString().equals(""))
                   {
                       preseneter.getActorData(s.toString());
                   }
                   else
                   {
                       actorsResult.clear();
                       actorAdapter.notifyDataSetChanged();
                   }

               }
               catch(Exception e) {
                   //Toast.makeText(getContext(), "Kosom el zamaelk", Toast.LENGTH_SHORT).show();
                }


            }
        });
        actorAdapter.setOnItemClickListner(new ActorAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                //Log.d("Txx", "onItemClick: ");
                ActorResult.ResultsBean actor=actorsResult.get(position);
                Log.d("Txx", "onItemClick: "+actor.getName());
                Intent intent= new Intent(getContext(), ActorDetail.class);
                intent.putExtra("actor",actor);
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onGetActorData(List<ActorResult.ResultsBean> resultsBeans) {
        actorsResult.clear();
        actorsResult.addAll(resultsBeans);
        Log.d("mes", "onGetActorData: "+actorsResult.size());
        actorAdapter.notifyDataSetChanged();

    }
}
