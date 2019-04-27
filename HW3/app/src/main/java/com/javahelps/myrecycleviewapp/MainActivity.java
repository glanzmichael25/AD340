package com.javahelps.myrecycleviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //define variables for the widgets
    private Button buttonMovies;
    private Button buttonToast1;
    private Button buttonToast2;
    private Button buttonToast3;

    //declare other variables
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets
        buttonMovies = findViewById(R.id.button1);
        buttonToast1 = findViewById(R.id.button2);
        buttonToast2 = findViewById(R.id.button3);
        buttonToast3 = findViewById(R.id.button4);

        //calls Toast functions
        showToast1();
        showToast2();
        showToast3();
    }
    @Override
    public void onClick(View view) {
        //creates intent to send to SecondActivity
        intent = new Intent(this, SecondActivity.class);
        //sends intent to SecondActivity
        startActivity(intent);
    }

    //Displays message when Toast1 button is clicked on
    private void showToast1() {
        buttonToast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast Button 1", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    //Displays message when Toast2 button is clicked on
    private void showToast2() {
        buttonToast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast Button 2", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    //Displays message when Toast3 button is clicked on
    private void showToast3() {
        buttonToast3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Toast Button 3", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}