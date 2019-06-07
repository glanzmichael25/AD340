package com.asynchronousnetworkconnectionsapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CameraAdapter extends ArrayAdapter<Cameras> {

        //declares variables
        private final Context context;
        private final Cameras[] cameras;

        public CameraAdapter(Context context, Cameras[] cameras) {
            super(context, -1, cameras);
            this.context = context;
            this.cameras = cameras;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //gets references for layout
            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView label = new TextView(context);
            label.setText(cameras[position].getLabel());

            TextView url = new TextView(context);
            url.setText(cameras[position].getImageUrl());

            layout.addView(label);
            layout.addView(url);
            return layout;
        }
    }
