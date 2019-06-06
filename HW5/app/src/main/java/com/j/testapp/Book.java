package com.j.testapp;

import android.content.Context;

public class Book {

    //declare variables
    private String title;
    private String oldbookOrNewbook;



    public Book(String title, String oldbookOrNewbook) {

        this.title = title;
        this.oldbookOrNewbook = oldbookOrNewbook;
    }

    public Book(){
        //empty constructor
    }


    public Book(Context context) {
        this.title = "Title";
        this.oldbookOrNewbook = "Used";
    }

    //declare getters
    public String getTitle() {

        return title;
    }


    //declare setters
    public void setTitle(String title) {

        this.title = title;
    }

    public String getoldbookOrNewbook() {

        return oldbookOrNewbook;
    }

    public void setoldbookOrNewbook(String rentOrBuy) {

        this.oldbookOrNewbook = oldbookOrNewbook;
    }


    public void oldbookOrNewbook(String oldbookOrNewbook) {

        this.oldbookOrNewbook = oldbookOrNewbook;
    }

    public double cost(int quantity){
        double cost = 0.0;

        if (getoldbookOrNewbook().equals("Used Book")){
            cost = 9.95;

        } else if (getoldbookOrNewbook().equals("New Book")){
            cost = 24.95;
        }

        return cost * quantity;
    }

}
