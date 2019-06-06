package com.asynchronousnetworkconnectionsapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class CameraRecyclerViewAdapter extends RecyclerView.Adapter<CameraRecyclerViewAdapter.ViewHolder> {


        //declares variables
        private Cameras[] cameras;

        //setup listener
        private Listener listener;

        public void setListener(Listener listener) {

            this.listener = listener;
        }

        interface Listener {
            void onClick(int position);
        }

        //private Cameras[] cameras;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private CardView layout;

            public ViewHolder(CardView view) {
                super(view);
                layout = view;
            }
        }

        public CameraRecyclerViewAdapter(Cameras[] cams) {
            this.cameras = cams;
        }

        //get camera count
        @Override
        public int getItemCount() {

            return cameras.length;
        }

        //inflates cardView layout
        @Override
        public CameraRecyclerViewAdapter.ViewHolder onCreateViewHolder(

                ViewGroup parent, int viewType) {

            CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
            return new ViewHolder(cardView);
        }

        //Loads camera views
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            //gets references for layout
            CardView cardView = holder.layout;
            TextView label = cardView.findViewById(R.id.label);
            ImageView pic = cardView.findViewById(R.id.camera);

            Cameras camera = cameras[position];
            label.setText(camera.getLabel());

            Picasso.get().load(cameras[position].getImageUrl()).into(pic);

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
