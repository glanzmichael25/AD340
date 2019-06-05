package com.asynchronousnetworkconnectionsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import static com.asynchronousnetworkconnectionsapp.MainActivity.MESSAGE_ID;

public class RecyclerViewActivity extends Activity {

    //declares variables
    private Cameras[] cameraViews;


    //sets up recyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        String info = intent.getStringExtra(MESSAGE_ID);


        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        this.cameraViews = Cameras.initCameras(info);
        CameraRecyclerViewAdapter adapter = new CameraRecyclerViewAdapter(cameraViews);
        recyclerView.setAdapter(adapter);
    }
}

