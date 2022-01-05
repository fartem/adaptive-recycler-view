package com.smlnskgmail.jaman.adaptiverecyclerview.recyclerview

import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveRecyclerView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import org.junit.Test

class RecyclerViewTest : BaseUITest() {

    @Test
    fun checkConstructors() {
        AdaptiveRecyclerView(context())
        AdaptiveRecyclerView(
            context(),
            null
        )
        AdaptiveRecyclerView(
            context(),
            null,
            0
        )
    }

}
