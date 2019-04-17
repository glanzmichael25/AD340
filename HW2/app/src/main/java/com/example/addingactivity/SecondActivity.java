package com.example.addingactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends Activity {

    //declare constants
    private static final String TAG = "SecondActivity Log";

    //define variables for the widgets
    private TextView textview;
    private TextView textview2;

    //declare variables
    private Intent intent;
    private String message;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        //gets intent from MainActivity
        intent = getIntent();

        //places text from MainActivity into message
        message = intent.getStringExtra(MainActivity.MESSAGE_ID);

        setContentView(R.layout.activity_second);

        //get references to the widgets
        textview = (TextView)findViewById(R.id.textView);
        textview2 = (TextView)findViewById(R.id.textView2);

        //displays message
        textview.setText(message);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Resumed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroyed");
    }
}
