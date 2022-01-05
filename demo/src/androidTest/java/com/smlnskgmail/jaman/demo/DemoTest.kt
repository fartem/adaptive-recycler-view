package com.smlnskgmail.jaman.demo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveRecyclerView
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class DemoTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkItemsLoading() {
        val adaptiveRecyclerView = activityTestRule.activity.findViewById<AdaptiveRecyclerView>(R.id.demo_list)

        assertNull(adaptiveRecyclerView.adapter)

        refreshClick()

        assertTrue(adaptiveRecyclerView.adapter!!.itemCount > 0)

        refreshClick()

        assertEquals(
            0,
            adaptiveRecyclerView.adapter!!.itemCount
        )
    }

    private fun refreshClick() {
        onView(withId(R.id.demo_list_refresh)).perform(click())
    }

}