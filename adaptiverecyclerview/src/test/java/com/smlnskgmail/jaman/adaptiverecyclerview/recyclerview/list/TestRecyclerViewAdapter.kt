package com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview.list

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TestRecyclerViewAdapter(
    private val context: Context,
    private val testItems: List<TestItem>
) : RecyclerView.Adapter<TestRecyclerViewAdapter.TestRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestRecyclerViewHolder {
        return TestRecyclerViewHolder(View(context))
    }

    override fun getItemCount(): Int {
        return testItems.size
    }

    override fun onBindViewHolder(holder: TestRecyclerViewHolder, position: Int) {
        holder.bind()
    }

    inner class TestRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind() {

        }

    }

}
