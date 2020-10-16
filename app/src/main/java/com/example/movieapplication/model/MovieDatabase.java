package com.example.movieapplication.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = MoviesResult.ResultsBean.class, version = 2)
abstract  public class MovieDatabase extends RoomDatabase {
    private static MovieDatabase instance;
    public abstract MoviesDao moviesDao();

    public static synchronized MovieDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context,MovieDatabase.class,"movie_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;

    }


}
