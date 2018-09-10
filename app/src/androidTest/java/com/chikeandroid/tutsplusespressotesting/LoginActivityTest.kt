package com.chikeandroid.tutsplusespressotesting

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<LoginActivity>(
            LoginActivity::class.java
    )

    private val username = "chike"
    private val password = "password"

    @Test
    fun clickLoginButton_opensLoginUi() {
        onView(withId(R.id.et_username)).perform(ViewActions.typeText(username))
        onView(withId(R.id.et_password)).perform(ViewActions.typeText(password))

        onView(withId(R.id.btn_submit)).perform(ViewActions.scrollTo(), ViewActions.click())

        Espresso.onView(withId(R.id.tv_login))
                .check(matches(withText("Success")))
    }
}