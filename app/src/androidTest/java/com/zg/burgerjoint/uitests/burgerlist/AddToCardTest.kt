package com.zg.burgerjoint.uitests.burgerlist

import android.content.Intent
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.MainActivity
import com.zg.burgerjoint.uitests.utils.first
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
open class AddToCardTest {

    private val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapAddToCard_numberOfItemsInCartIncreased() {

        onView(first<View>(withId(R.id.btnAddToCart)))
            .perform(click())

        onView(withId(R.id.tvCartCount))
            .check(matches(withText("1")))
    }
}