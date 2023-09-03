package com.example.applicacion1

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun whenSameStringsEntered_displaysEqualMessage() {
        onView(withId(R.id.editText1)).perform(typeText("test"), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText("test"), closeSoftKeyboard())
        onView(withId(R.id.btnCompare)).perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("Las cadenas son iguales")))
    }

    @Test
    fun whenDifferentStringsEntered_displaysNotEqualMessage() {
        onView(withId(R.id.editText1)).perform(typeText("test1"), closeSoftKeyboard())
        onView(withId(R.id.editText2)).perform(typeText("test2"), closeSoftKeyboard())
        onView(withId(R.id.btnCompare)).perform(click())
        onView(withId(R.id.resultTextView)).check(matches(withText("Las cadenas no son iguales")))
    }
}
