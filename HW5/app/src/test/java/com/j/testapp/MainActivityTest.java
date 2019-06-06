package com.j.testapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {


    @Test
    public void testToast(){

        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        activity.findViewById(R.id.button_show_cost).performClick();

        assertEquals("Input required", ShadowToast.getTextOfLatestToast());
    }
}
