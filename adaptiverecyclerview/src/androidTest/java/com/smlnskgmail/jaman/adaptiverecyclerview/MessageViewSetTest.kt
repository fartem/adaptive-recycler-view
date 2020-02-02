package com.smlnskgmail.jaman.adaptiverecyclerview

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertNotNull
import org.junit.Test

class MessageViewSetTest {

    private val context = InstrumentationRegistry.getInstrumentation().context

    @Test
    fun checkForNonNullView() {
        val adaptiveRecyclerView = AdaptiveRecyclerView(context)
        adaptiveRecyclerView.messageView = AdaptiveMessageView(context)

        assertNotNull(
            adaptiveRecyclerView.messageView
        )
    }

    @Test(expected = IllegalStateException::class)
    fun checkForNullView() {
        val adaptiveRecyclerView = AdaptiveRecyclerView(context)
        adaptiveRecyclerView.messageView = null
    }

}
