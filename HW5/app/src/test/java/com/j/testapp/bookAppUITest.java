package com.j.testapp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


//imports
import android.support.test.runner.AndroidJUnit4;
import org.junit.runner.RunWith;
import android.support.test.espresso.Espresso.onView;
import android.support.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.CoreMatchers.instanceOf;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class bookAppUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testBookFeatures(){
        onView(withID(R.id.simple_spinner_dropdown_item))
                .preformClick(click());
        onData(allOf(is(instanceOf(String.class)), is("The Hobbit")))
                .perform(click());

        //onView(withID(R.id.edit_text_book_quantity))

        onView(withID(R.id.button_show_cost)).perform(click());

    }

}
