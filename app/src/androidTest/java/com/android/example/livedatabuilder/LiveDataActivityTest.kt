package com.android.example.livedatabuilder


import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.android.example.livedata.DataBindingIdlingResource
import com.android.example.livedata.R
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class LiveDataActivityTest {


    @get:Rule
    val activityRule = ActivityTestRule(LiveDataActivity::class.java,false,true)

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(LiveDataActivity::class.java)

    private lateinit var dataBindingIdlingResource: IdlingResource

    @Before
    fun registerIdlingResources() {
        dataBindingIdlingResource = DataBindingIdlingResource(activityScenarioRule)
        IdlingRegistry.getInstance().register(dataBindingIdlingResource)
    }

    @After
    fun unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(dataBindingIdlingResource)
    }
    @Test
    fun liveDataActivityTest() {
        onView(withId((R.id.refresh_button))).check(matches(isDisplayed()));
    }

    @Test
    fun doScreenshot() {
//        Thread.sleep(2000)
     Screenshot.snapActivity(activityRule.activity).setName("displayActivity").record()
    }
}
