package com.example.yiweizhang.csci3130project;


import android.content.ComponentName;
import android.content.Intent;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
  //  public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    public IntentsTestRule<LoginActivity> intentsTestRule =
            new IntentsTestRule<>(LoginActivity.class);




    @Test
    public void Test1() {
        onView(withId(R.id.userEnteredEmail)).
                perform(typeText("aaabbbc@dal.ca"),closeSoftKeyboard());
        onView(withId(R.id.userEnteredPassword)).
                perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.studentClickSignIn)).perform(click());

    }
    public void Test2() {
        onView(withId(R.id.userEnteredEmail)).
                perform(typeText("abc@dal.ca"),closeSoftKeyboard());
        onView(withId(R.id.userEnteredPassword)).
                perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.studentClickSignIn)).perform(click());

    }
    public void Test3() {
        onView(withId(R.id.userEnteredEmail)).
                perform(typeText("abc@dal.ca"),closeSoftKeyboard());
        onView(withId(R.id.userEnteredPassword)).
                perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.professorClickSignIn)).perform(click());

    }
    public void Test4() {
        onView(withId(R.id.userEnteredEmail)).
                perform(typeText("abc@dal.ca"),closeSoftKeyboard());
        onView(withId(R.id.userEnteredPassword)).
                perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.professorClickSignIn)).perform(click());

    }



}
