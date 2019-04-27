package com.javahelps.myrecycleviewapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {

    //define variables for the widgets
    private TextView title;
    private TextView year;
    private TextView director;
    private TextView description;

    //declare other variables
    private ScaryMovies[] movie;
    private int position;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //get references to the widgets
        title = findViewById(R.id.title);
        year = findViewById(R.id.year);
        director = findViewById(R.id.director);
        description = findViewById(R.id.description);

        //get references to data
        intent = getIntent();
        bundle = intent.getExtras();

        if (bundle != null) {
            position = Integer.parseInt(bundle.getString("MOVIE_POS"));
        }

        //initialize movies
        this.movie = ScaryMovies.initMovies();


        //sets data to textViews
        title.setText("Movie: " + movie[position].getTitle());
        year.setText("Year: " + Integer.toString(movie[position].getYear()));
        director.setText("Director: " + movie[position].getDirector());
        description.setText("Description: " + movie[position].getDescription());
    }
}
