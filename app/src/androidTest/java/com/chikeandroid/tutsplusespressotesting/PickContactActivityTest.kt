package com.chikeandroid.tutsplusespressotesting

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.provider.ContactsContract
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers.*
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PickContactActivityTest {

    @Rule
    @JvmField
    var intentRule = IntentsTestRule<PickContactActivity>(
            PickContactActivity::class.java
    )

    @Test
    fun stubPick() {
        var result = Instrumentation.ActivityResult(Activity.RESULT_OK, Intent(null,
                ContactsContract.Contacts.CONTENT_URI))
        intending(hasAction(Intent.ACTION_PICK)).respondWith(result)
        onView(withId(R.id.btn_select_contact)).perform(click())

        intended(allOf(
                toPackage("com.google.android.contacts"),
                hasAction(Intent.ACTION_PICK),
                hasData(ContactsContract.Contacts.CONTENT_URI)))

        /// onView(withId(R.id.view)).check(matches(isEnabled()));
    }
}