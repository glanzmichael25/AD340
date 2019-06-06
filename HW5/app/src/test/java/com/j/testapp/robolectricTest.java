package com.j.testapp;


import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;


import static com.google.common.truth.Truth.assertThat;

@RunWith(RobolectricTestRunner.class)
public class robolectricTest {

    @Test
    public void defaul_book_correct_value(){

        Context roboContext = ApplicationProvider.getApplicationContext();

        Book defaultBook = new Book(roboContext);

        String correctTitle = defaultBook.getTitle();
        assertThat(correctTitle).isEqualTo("The Hobbit");

        String correctBookType = defaultBook.getoldbookOrNewbook();
        assertThat(correctBookType).isEqualTo("Used");
    }
}
