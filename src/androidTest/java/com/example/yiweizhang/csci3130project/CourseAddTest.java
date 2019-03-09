package com.example.yiweizhang.csci3130project;

/**
 * Created by denghaohai on 27/02/2018.
 */

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class CourseAddTest {

    @Rule
    public ActivityTestRule<CourseAddActivity> mActivityTestRule = new ActivityTestRule<>(CourseAddActivity.class);

    @Test
    public void Case1() {
        onView(withId(R.id.CourseID)).
                perform(typeText("4144"),closeSoftKeyboard());
        onView(withId(R.id.Capacity)).
                perform(typeText("90"),closeSoftKeyboard());
        onView(withId(R.id.Location)).
                perform(typeText("Chemistry"),closeSoftKeyboard());
        onView(withId(R.id.endtime)).
                perform(typeText("6:30"),closeSoftKeyboard());
        onView(withId(R.id.Date)).
                perform(typeText("1/8"),closeSoftKeyboard());
        onView(withId(R.id.Submit)).perform(click());




    }
    @Test
    public void Case2() {
        onView(withId(R.id.CourseID)).
                perform(typeText("4144"),closeSoftKeyboard());
        onView(withId(R.id.Capacity)).
                perform(typeText("90"),closeSoftKeyboard());
        onView(withId(R.id.endtime)).
                perform(typeText("6:30"),closeSoftKeyboard());
        onView(withId(R.id.Date)).
                perform(typeText("1/8"),closeSoftKeyboard());
        onView(withId(R.id.Submit)).perform(click());



    }

}
