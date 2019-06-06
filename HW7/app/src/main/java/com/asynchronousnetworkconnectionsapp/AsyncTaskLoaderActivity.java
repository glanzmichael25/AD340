package com.asynchronousnetworkconnectionsapp;

import android.content.Context;
import android.support.annotation.Nullable;

public class AsyncTaskLoaderActivity extends android.support.v4.content.AsyncTaskLoader<String> {

    //declares variables
    private String queryString;

    //sets up AsyncTaskLoader
    public AsyncTaskLoaderActivity(Context context, String queryString) {
        super(context);
        this.queryString = queryString;
    }

    //Loads map connects to network
    @Nullable
    @Override
    public String loadInBackground() {

        String baseURL = "https://web6.seattle.gov/Travelers/api/Map/Data";

        return NetConnection.getData(baseURL, "zoomId", queryString, "type", "2");
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }
}
