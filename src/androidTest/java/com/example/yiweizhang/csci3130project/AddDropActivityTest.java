package com.example.yiweizhang.csci3130project;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddDropActivityTest {

    @Rule
    public ActivityTestRule<AddDropActivity> mActivityTestRule = new ActivityTestRule<>(AddDropActivity.class);

    @Test
    public void addDropActivityTest() {
        onView(withId(R.id.AddClassbtn)).perform(click());
        onView(withId(R.id.DropClassBtn)).perform(click());
    }

}
