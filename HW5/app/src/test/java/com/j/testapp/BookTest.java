package com.j.testapp;

import android.content.Context;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static com.google.common.truth.Truth.assertThat;

public class BookTest {


    Book testBook;
    Book testBook2;


    @Before
    public void setUp(){
        this.testBook = new Book("The Hobbit", "Used Book");
        this.testBook2 = new Book("The Hobbit", "New Book");

    }

    @Test
    public void testBook_constructor(){
        String book_correct = testBook.getTitle();
        assertThat(book_correct).isEqualTo("The Hobbit");
    }


    @Test
    public void testBook_returns_correct_value_Used() {
        double bookCostGood = testBook.cost(1);
        assertThat(bookCostGood).isEqualTo(9.95);
    }

    @Test
    public void testBook_returns_correct_value2_Used() {
        double bookCostGood = testBook.cost(5);
        assertThat(bookCostGood).isEqualTo(49.75);
    }

    @Test
    public void testBook_returns_correct_value_New() {
        double bookCostGood = testBook2.cost(1);
        assertThat(bookCostGood).isEqualTo(24.95);
    }

    @Test
    public void testBook_returns_correct_value2_New() {
        double bookCostGood = testBook2.cost(2);
        assertThat(bookCostGood).isEqualTo(49.90);
    }

    @After
    public void tearDown(){

    }


}
