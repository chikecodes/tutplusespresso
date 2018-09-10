package com.chikeandroid.tutsplusespressotesting

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
            MainActivity::class.java
    )

    @Test
    fun clickLoginButton_opensLoginUi() {
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_login)).perform(click())

        onView(withId(R.id.tv_login)).check(matches(isDisplayed()))


        /*.perform(click())

        // Check if the add note screen is displayed
        onView(withId(R.id.add_note_title)).check(matches(isDisplayed()))*/
    }
}