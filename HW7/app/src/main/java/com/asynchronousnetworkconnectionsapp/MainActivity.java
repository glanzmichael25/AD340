package com.asynchronousnetworkconnectionsapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<String> {

    //declare variables
    private TextView message;
    private ImageView videoView;

    public static final String MESSAGE_ID = "messageID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declares button to start cameraView
        Button button = findViewById(R.id.button_cameras);
        button.setOnClickListener(this);
        //gets references
        message = findViewById(R.id.result);
        videoView = findViewById(R.id.pic);
    }

    @Override
    public void onClick(View view){

        //attempts to establish connection
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnected()) {
            message.setText(getResources().getString(R.string.connecting));

            Bundle bundle = new Bundle();
            bundle.putString("queryString", "13");
            getSupportLoaderManager().restartLoader(0, bundle, this);
        } else {
            message.setText(getResources().getString(R.string.failed_connection));
        }
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {

        // Loads stringQuery
        String queryString = "";
        if (bundle != null) {
            queryString = bundle.getString("queryString");
        }

        return new AsyncTaskLoaderActivity(this, queryString);
    }
    
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

        LoadCams(data);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
    }

    //sends intent to recyclerView activity
    public void LoadCams(String query) {
        
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        intent.putExtra(MESSAGE_ID, query);
        startActivity(intent);
    }
}