package com.example.addingactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declare constants
    private static final String TAG = "MainActivity Log";
    public static final String MESSAGE_ID = "Message goes here";

    //define variables for the widgets
    private EditText editText;
    private Button button;

    //declare variables
    private String message;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sends log message to Logcat
        Log.i(TAG, this.getLifecycle()
                .getCurrentState()
                .toString());

        //get references to the widgets
        editText = (EditText)findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        //set the listener on button
        button.setOnClickListener(this);
    }

    public void onClick(View button){
        Log.i(TAG, "Button " + button.getId() + " clicked.");

        //gets text input from editText and places in message variable
        message = editText.getText().toString();

        //creates intent to send to SecondActivity
        intent = new Intent(this, SecondActivity.class);

        //adds contents of message to intent
        intent.putExtra(MESSAGE_ID, message);

        //sends intent to SecondActivity
        startActivity(intent);


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



