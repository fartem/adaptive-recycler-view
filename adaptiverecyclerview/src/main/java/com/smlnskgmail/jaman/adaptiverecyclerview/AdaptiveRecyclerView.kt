package com.smlnskgmail.jaman.adaptiverecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AdaptiveRecyclerView : RecyclerView {

    private var messageView: View? = null
        set(value) {
            field = value
        }

    private val dataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            checkItemsList()
        }

        fun checkItemsList() {
            if (adapter != null) {
                if (adapter!!.itemCount == 0) {
                    visibility = View.GONE
                    messageView!!.visibility == View.VISIBLE
                } else {
                    visibility = View.VISIBLE
                    messageView!!.visibility == View.GONE
                }
            }
        }

        override fun onItemRangeInserted(
            positionStart: Int,
            itemCount: Int
        ) {
            checkItemsList()
        }

        override fun onItemRangeRemoved(
            positionStart: Int,
            itemCount: Int
        ) {
            checkItemsList()
        }
    }

    constructor(context: Context) : super(context)

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs)

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun setAdapter(adapter: Adapter<*>?) {
        adapter?.unregisterAdapterDataObserver(dataObserver)
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(dataObserver)
        dataObserver.onChanged()
    }

}