package com.asynchronousnetworkconnectionsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import static com.asynchronousnetworkconnectionsapp.MainActivity.MESSAGE_ID;

public class RecyclerViewActivity extends Activity {

    //declares variables
    private Cameras[] cameraViews;
    final static String RESULT = "RECYCLERVIEW RESPONSE";


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



        adapter.setListener(new CameraRecyclerViewAdapter.Listener() {
            @Override
            public void onClick(int position) {
                //Log.i(TAG, "Clicked " + position + " " + cams[position].getImageUrl());
                Intent intent = new Intent(getApplicationContext(),
                        MapActivity.class);
                String[] camPackage = new String[4];
                camPackage[0] = Double.toString(cameraViews[position].getLatitude());
                camPackage[1] = Double.toString(cameraViews[position].getLongitude());
                camPackage[2] = cameraViews[position].getLabel();
                camPackage[3] = cameraViews[position].getImageUrl();
                intent.putExtra(RESULT, camPackage);
                startActivity(intent);
            }
        });
    }


}

