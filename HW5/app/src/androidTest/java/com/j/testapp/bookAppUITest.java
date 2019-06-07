package com.j.testapp;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import androidx.test.espresso.ViewAction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onData;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class bookAppUITest {


    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testBookFeatures(){

        //choose book from spinner
        onView(withId(R.id.spinner))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), is("The Hobbit")))
                .perform((ViewAction) click());

        //choose radio button
        onView(withId(R.id.used_book))
                .perform(click());

        onView(withId(R.id.used_book))
                .check(matches(isChecked()));

        onView(withId(R.id.new_book))
                .check(matches(not(isChecked())));

        //checks quantity input value
        onView(withId(R.id.edit_text_book_quantity)).perform(typeText("5"));


        //checks that button is clicked
        onView(withId(R.id.button_show_cost)).perform(click());

        //checks output
        //onView(withText("this is camel case"))
                //.check(matches(isDisplayed()));

        //checks output
        onView(withId(R.id.cost))
                .perform(click())
                .check(matches(isDisplayed()));

    }
}
