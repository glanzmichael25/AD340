package com.j.testapp;

import android.content.Context;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static com.google.common.truth.Truth.assertThat;

public class BookTest {


    Book testBook;


    @Before
    public void setUp(){
        this.testBook = new Book("The Hobbit", "Used");

    }

    @Test
    public void testBook_constructor(){
        String book_correct = testBook.getTitle();
        assertThat(book_correct).isEqualTo("The Hobbit");
    }

    public void testBook_empty_constructor(){
        String book_correct_empty = testBook.getTitle();
        assertThat(book_correct_empty).isEqualTo("Title", "Used");
    }


    //public void testBook_returns_correct_value() {
        //double bookCostGood = testBook.cost(1);
        //assertThat(bookCostGood).isEqualTo(9.95);
    //}

    @After
    public void tearDown(){

    }


}
