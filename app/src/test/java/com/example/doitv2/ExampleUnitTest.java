package com.example.doitv2;

import org.junit.Before;
import org.junit.Test;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

import android.content.Intent;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest<MainActivity> {

    private MainActivity activity;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


}