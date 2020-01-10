package com.smlnskgmail.jaman.adaptiverecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

class AdaptiveMessageView : LinearLayout {

    constructor(context: Context?) : super(context)

    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : super(context, attrs)

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        LayoutInflater.from(context).inflate(
            R.layout.view_adaptive_message,
            this,
            true
        )
    }

}
