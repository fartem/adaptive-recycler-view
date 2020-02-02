package com.smlnskgmail.jaman.adaptiverecyclerview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test

class RecyclerViewStatesTest {

    private val context = InstrumentationRegistry.getInstrumentation().context

    @Test
    fun checkEmptyList() {
        val adaptiveRecyclerView = AdaptiveRecyclerView(context)
        adaptiveRecyclerView.messageView = AdaptiveMessageView(context)
        adaptiveRecyclerView.adapter = TestRecyclerViewAdapter(context, emptyList())

        isVisible(
            adaptiveRecyclerView.messageView!!
        )
        isGone(
            adaptiveRecyclerView
        )
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
        val adaptiveRecyclerView = AdaptiveRecyclerView(context)
        adaptiveRecyclerView.messageView = AdaptiveMessageView(context)
        adaptiveRecyclerView.adapter = TestRecyclerViewAdapter(
            context,
            arrayListOf(
                TestItem(),
                TestItem(),
                TestItem(),
                TestItem(),
                TestItem(),
                TestItem(),
                TestItem()
            )
        )

        isGone(
            adaptiveRecyclerView.messageView!!
        )
        isVisible(
            adaptiveRecyclerView
        )
    }

    private inner class TestItem

    private inner class TestRecyclerViewAdapter(
        private val context: Context,
        private val testItems: List<TestItem>
    ) : RecyclerView.Adapter<TestRecyclerViewAdapter.TestRecyclerViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): TestRecyclerViewHolder {
            return TestRecyclerViewHolder(View(context))
        }

        override fun getItemCount(): Int {
            return testItems.size
        }

        override fun onBindViewHolder(
            holder: TestRecyclerViewHolder,
            position: Int
        ) {
            holder.bind(testItems[position])
        }

        inner class TestRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            fun bind(testItem: TestItem) {

            }

        }

    }

}