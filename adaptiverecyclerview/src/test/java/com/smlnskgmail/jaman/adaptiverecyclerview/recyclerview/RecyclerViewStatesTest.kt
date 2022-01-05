package com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview

import android.view.View
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveMessageView
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveRecyclerView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview.list.TestItem
import com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview.list.TestRecyclerViewAdapter
import org.junit.Assert.*
import org.junit.Test

class RecyclerViewStatesTest : BaseUITest() {

    @Test
    fun checkEmptyList() {
        val recyclerView = AdaptiveRecyclerView(context())
        recyclerView.messageView = AdaptiveMessageView(context())
        recyclerView.adapter = TestRecyclerViewAdapter(
            context(),
            emptyList()
        )

        isVisible(recyclerView.messageView!!)
        isGone(recyclerView)
    }

    private fun isVisible(view: View) {
        assertEquals(
            View.VISIBLE,
            view.visibility
        )
    }

    private fun isGone(view: View) {
        assertEquals(
            View.GONE,
            view.visibility
        )
    }

    @Test
    fun checkListWithItems() {
        val recyclerView = AdaptiveRecyclerView(context())
        recyclerView.messageView = AdaptiveMessageView(context())
        recyclerView.adapter = TestRecyclerViewAdapter(
            context(),
            TestItem.collection()
        )

        isGone(recyclerView.messageView!!)
        isVisible(recyclerView)
    }

    @Test
    fun checkAdapterSecondSet() {
        val recyclerView = AdaptiveRecyclerView(context())
        recyclerView.messageView = AdaptiveMessageView(context())

        val adapter = TestRecyclerViewAdapter(
            context(),
            TestItem.collection()
        )
        recyclerView.adapter = adapter

        assertNotNull(recyclerView.adapter)

        recyclerView.adapter = adapter

        assertNotNull(recyclerView.adapter)
    }

    @Test
    fun checkNullAdapter() {
        val recyclerView = AdaptiveRecyclerView(context())
        recyclerView.adapter = null

        assertNull(recyclerView.adapter)
    }

    @Test
    fun checkNullMessageView() {
        val recyclerView = AdaptiveRecyclerView(context())
        recyclerView.adapter = TestRecyclerViewAdapter(
            context(),
            TestItem.collection()
        )
        isVisible(recyclerView)

        recyclerView.adapter = TestRecyclerViewAdapter(
            context(),
            emptyList()
        )
        isGone(recyclerView)

        assertNull(recyclerView.messageView)
    }

}
