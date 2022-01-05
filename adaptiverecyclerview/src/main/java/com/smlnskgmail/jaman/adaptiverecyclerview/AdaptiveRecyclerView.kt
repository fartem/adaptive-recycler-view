package com.smlnskgmail.jaman.adaptiverecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AdaptiveRecyclerView : RecyclerView {

    var messageView: View? = null
        set(value) {
            checkNotNull(value) {
                "messageView must not be null!"
            }
            field = value
        }

    private val dataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            checkItemsList()
        }

        fun checkItemsList() {
            visibility = if (adapter!!.itemCount == 0) {
                messageView?.visibility = View.VISIBLE
                View.GONE
            } else {
                messageView?.visibility = View.GONE
                View.VISIBLE
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

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

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
        if (getAdapter() != null) {
            getAdapter()!!.unregisterAdapterDataObserver(
                dataObserver
            )
        }
        super.setAdapter(adapter)
        if (adapter != null) {
            adapter.registerAdapterDataObserver(dataObserver)
            dataObserver.onChanged()
        }
    }

}
