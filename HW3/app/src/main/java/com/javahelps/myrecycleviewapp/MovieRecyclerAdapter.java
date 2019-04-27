package com.javahelps.myrecycleviewapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {

    //declare variables
    private CardView cardView;
    private Listener listener;
    private ScaryMovies[] movies;
    private TextView title;
    private TextView year;

    //sets movies
    public MovieRecyclerAdapter(ScaryMovies[] movies) {
        this.movies = movies;
    }

    //sets Listener
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onClick(int position);
    }

    //inner class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView layout;
        public ViewHolder(CardView v) {
            super(v);
            layout = v;
        }
    }
    //gets array length
    @Override
    public int getItemCount() {
        return movies.length;
    }

    //inflates views
    @Override
    public MovieRecyclerAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
        return new ViewHolder(cardView);
    }
    //binds data to views
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //get references to the widgets
        cardView = holder.layout;
        title = cardView.findViewById(R.id.title);
        year = cardView.findViewById(R.id.year);

        //sets data to textViews
        Context context = cardView.getContext();
        ScaryMovies movie = movies[position];
        title.setText("Movie: " + movie.getTitle());
        year.setText("Year: " + Integer.toString(movies[position].getYear()));

        //sets cardView OnClickLister
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
