package com.javahelps.myrecycleviewapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class SecondActivity extends Activity {

    //define variables
    public static final int MOVIE_POS = 0;
    private static final int RESULT_ID = 1;
    private ScaryMovies[] movie;
    public String send;
    private Intent intent;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //sets up recyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //initialize movies
        this.movie = ScaryMovies.initMovies();

        MovieRecyclerAdapter adapter = new MovieRecyclerAdapter(movie);
        recyclerView.setAdapter(adapter);

        adapter.setListener(new MovieRecyclerAdapter.Listener() {
            @Override
            public void onClick(int position) {
                send = Integer.toString(position);
                send();
            }
        });
    }

    public void send() {
        intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("MOVIE_POS", send);
        startActivity(intent);
    }
}

