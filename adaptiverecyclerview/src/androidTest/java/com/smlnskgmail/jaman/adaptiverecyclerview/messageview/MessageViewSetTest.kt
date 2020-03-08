package com.smlnskgmail.jaman.adaptiverecyclerview.messageview

import androidx.test.platform.app.InstrumentationRegistry
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveMessageView
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveRecyclerView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import org.junit.Assert.assertNotNull
import org.junit.Test

class MessageViewSetTest : BaseUITest() {

    private val context = InstrumentationRegistry.getInstrumentation().context

    @Test
    fun checkForNonNullView() {
        val recyclerView =
            AdaptiveRecyclerView(
                context
            )
        recyclerView.messageView =
            AdaptiveMessageView(
                context
            )

        assertNotNull(
            recyclerView.messageView
        )
    }

    @Test(expected = IllegalStateException::class)
    fun checkForNullView() {
        val adaptiveRecyclerView =
            AdaptiveRecyclerView(
                context
            )
        adaptiveRecyclerView.messageView = null
    }

}
