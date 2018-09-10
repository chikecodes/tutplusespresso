package com.chikeandroid.tutsplusespressotesting

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyListActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MyListActivity>(
            MyListActivity::class.java
    )

    @Test
    fun clickItem() {
        onView(withId(R.id.rv))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition<RandomAdapter.ViewHolder>(0, ViewActions.click()))

    }


}