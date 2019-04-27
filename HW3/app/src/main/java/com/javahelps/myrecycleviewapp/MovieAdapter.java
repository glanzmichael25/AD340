package com.javahelps.myrecycleviewapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MovieAdapter extends ArrayAdapter<ScaryMovies> {

    //define variables
    private final Context context;
    private final ScaryMovies[] movies;
    private LinearLayout layout;

    public MovieAdapter(Context context, ScaryMovies[] values) {
        super(context, -1, values);
        this.context = context;
        this.movies = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //gets references
        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(context);
        title.setText(movies[position].getTitle());

        TextView year = new TextView(context);
        year.setText(Integer.toString(movies[position].getYear()));

        //sets layout
        layout.addView(title);
        layout.addView(year);
        return layout;
    }
}
