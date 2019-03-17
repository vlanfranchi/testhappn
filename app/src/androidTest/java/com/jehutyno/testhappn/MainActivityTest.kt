package com.jehutyno.testhappn

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.jehutyno.testhappn.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testNavHostDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.nav_host_fragment)).check(matches((isDisplayed())))
    }

    @Test
    fun testFlipperDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.flipper)).check(matches((isDisplayed())))
    }

    @Test
    fun testRecyclerViewDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.articlesList)).check(matches((isDisplayed())))
    }

}