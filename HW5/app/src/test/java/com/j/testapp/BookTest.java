package com.j.testapp;

import android.content.Context;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

public class BookTest {


    Book testBook;
    Book testBook2;

    @Mock
    Context mockContext;


    @Before
    public void setUp(){
        this.testBook = new Book("The Hobbit", "Used Book");
        this.testBook2 = new Book("The Hobbit", "New Book");


        MockitoAnnotations.initMocks(this);

        when(mockContext.getString(R.string.default_title))
                .thenReturn("The Hobbit");
        when(mockContext.getString(R.string.default_bookType))
                .thenReturn("Used");

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

    @Test
    public void book_default_title() {
        Book defaultBook = new Book(mockContext);

        String correctTitle = defaultBook.getTitle();
        assertThat(correctTitle).isEqualTo("The Hobbit");


    }

    @Test
    public void book_default_Type() {
        Book defaultBook = new Book(mockContext);

        String correctBookType = defaultBook.getoldbookOrNewbook();
        assertThat(correctBookType).isEqualTo("Used");
    }

    /*@Test
    public void book_default_cost() {
        Book defaultBook = new Book(mockContext);

        double correctBookCost = defaultBook.cost(1);
        assertThat(correctBookCost).isEqualTo(9.95);
    }*/



    @After
    public void tearDown(){

    }


}
