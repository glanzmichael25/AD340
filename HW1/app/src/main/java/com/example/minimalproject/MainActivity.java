package com.example.minimalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String str = "Michael Glanz " + System.getProperty("line.separator") +
                "I am interested in creating mobile applications and am looking forward " +
                "to learning how to develop apps throughout this course. My hope is to " +
                "become proficient with mobile development so that I can move into a " +
                "developer role at my current employment.";
        TextView label = new TextView(this);
        label.setText(str);

        setContentView(label);
    }
}
