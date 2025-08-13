package com.atdroid.atyurin.futuremoney

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atdroid.atyurin.futuremoney.activity.MainActivity
import com.atdroid.atyurin.futuremoney.utils.ClearDatabase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SanityTest {
    @get:Rule val rule = ActivityScenarioRule(MainActivity::class.java)
    @get:Rule
    val clearDatabase = ClearDatabase()
    @Test fun toolbar_isVisible() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
    }
}
