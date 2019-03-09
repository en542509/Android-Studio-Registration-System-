package com.example.yiweizhang.csci3130project;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static org.junit.Assert.*;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Instrumented test, which will execute on an Android device.
 *by Shuo
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.yiweizhang.csci3130project", appContext.getPackageName());
    }

    @Test
    public void test0() {
    ViewInteraction appCompatViewPager = onView(
            allOf(withId(R.id.listView), isDisplayed()));
    }
    @Test
    public void test1(){
        onView(withText("Database Design")).perform(click());
    }
    @Test
    public void test2(){
        onView(withText("Ensemble")).perform(click());
    }
    @Test
    public void test3(){
        onView(withText("Ensemble 1")).perform(click());
    }
    @Test
    public void test4(){
        onView(withText("Voice")).perform(click());
    }
    @Test
    public void test5(){
        onView(withText("Guitar")).perform(click());
    }
    @Test
    public void test6(){
        onView(withText("Piano")).perform(click());
    }
    @Test
    public void test7(){
        onView(withText("violin")).perform(click());
    }
    @Test
    public void test8(){
        onView(withText("French")).perform(click());
    }
    @Test
    public void test9(){
        onView(withText("Spanish")).perform(click());
    }
    @Test
    public void test10(){
        onView(withText("Chinese")).perform(click());
    }
    @Test
    public void test11(){
        onView(withText("Japanese")).perform(click());
    }
    @Test
    public void test12(){
        onView(withText("German Fiction")).perform(click());
    }
    @Test
    public void test13(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Halifax and the world")).perform(click());
    }
    @Test
    public void test14(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Introduction to Java")).perform(click());
    }
    @Test
    public void test15(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Introduction to C")).perform(click());
    }
    @Test
    public void test16(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Introduction to python")).perform(click());
    }
    @Test
    public void test17(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Introduction to C++")).perform(click());
    }
    @Test
    public void test18(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Introduction to UI")).perform(click());
    }
    @Test
    public void test19(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Math 2112")).perform(click());
    }
    @Test
    public void test20(){
        ViewInteraction appCompatViewPager = onView(
                allOf(withId(R.id.listView), isDisplayed()));
        appCompatViewPager.perform(swipeUp());
        onView(withText("Math 2001")).perform(click());
    }


}
