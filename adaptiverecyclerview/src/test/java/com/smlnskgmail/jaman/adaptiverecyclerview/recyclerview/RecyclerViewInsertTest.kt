package com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview

import android.view.View
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveRecyclerView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview.list.TestItem
import com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview.list.TestRecyclerViewAdapter
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RecyclerViewInsertTest : BaseUITest() {

    private val testItems = TestItem.collection() as ArrayList

    private lateinit var recyclerView: AdaptiveRecyclerView
    private lateinit var recyclerViewAdapter: TestRecyclerViewAdapter

    @Before
    fun setup() {
        recyclerView = AdaptiveRecyclerView(context())
        recyclerViewAdapter = TestRecyclerViewAdapter(
            context(),
            testItems
        )
        recyclerView.messageView = View(context())
        recyclerView.adapter = recyclerViewAdapter

        assertItemsCount()
    }

    private fun assertItemsCount() {
        assertEquals(
            testItems.size,
            recyclerViewAdapter.itemCount
        )
    }

    @Test
    fun checkInsert() {
        testItems.add(TestItem())
        recyclerViewAdapter.notifyItemInserted(testItems.size - 1)

        assertItemsCount()
    }

    @Test
    fun checkRemove() {
        val count = testItems.size
        testItems.clear()

        recyclerViewAdapter.notifyItemRangeRemoved(
            0,
            count - 1
        )

        assertItemsCount()
    }

}
