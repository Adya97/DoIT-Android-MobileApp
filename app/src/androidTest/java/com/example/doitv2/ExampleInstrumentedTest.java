package com.example.doitv2;

import android.app.Activity;
import android.content.Context;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.doitv2.SplashActivity;

import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onView;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest<SplashActivity extends Activity> {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.doitv2", appContext.getPackageName());
    }

    @Test
    public void checkTaskText(){
        onView(withId(R.id.tasksText)).check(matches(withText("Tasks")));
    }

    @Rule
    public ActivityScenarioRule<com.example.doitv2.SplashActivity> activityScenarioRule = new ActivityScenarioRule<>(com.example.doitv2.SplashActivity.class);

    @Test
    public void splashScreenIsDisplayed() {
        onView(withId(R.id.splash_screen_layout)).check(matches(isDisplayed()));
        try {
            Thread.sleep(1000); // This is the delay time of my splash screen handler
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkTodoTasksAppearing(){
        onView(withId(R.id.newTaskButton)).check(matches(withText("Tasks")));
    }

    @Test
    public void checkTaskOneIsDisplayed() {
        onView(withText("Clean the Bedroom")).check(matches(isDisplayed()));
    }

    @Test
    public void checkTaskTwoIsDisplayed() {
        onView(withText("Go to Gym")).check(matches(isDisplayed()));
    }
}
