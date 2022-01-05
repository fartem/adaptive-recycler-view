package com.smlnskgmail.jaman.adaptiverecyclerview.messageview

import androidx.core.content.ContextCompat
import androidx.test.platform.app.InstrumentationRegistry
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveMessageView
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveRecyclerView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import com.smlnskgmail.jaman.adaptiverecyclerview.R
import kotlinx.android.synthetic.main.view_adaptive_message.view.*
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Test

class MessageViewSetTest : BaseUITest() {

    private val context = InstrumentationRegistry.getInstrumentation().context

    @Test
    fun checkForNonNullView() {
        val recyclerView = AdaptiveRecyclerView(context)
        recyclerView.messageView = AdaptiveMessageView(context)

        assertNotNull(recyclerView.messageView)
    }

    @Test(expected = IllegalStateException::class)
    fun checkForNullView() {
        val adaptiveRecyclerView = AdaptiveRecyclerView(context)
        adaptiveRecyclerView.messageView = null
    }

    @Test
    fun checkImageSetup() {
        val messageView = AdaptiveMessageView(context())

        messageView.setImage(R.drawable.ic_adaptive_message_view_image)
        messageView.setImage(
            ContextCompat.getDrawable(
                context(),
                R.drawable.ic_adaptive_message_view_image
            )!!
        )
    }

    @Test
    fun checkTextSetup() {
        val messageView = AdaptiveMessageView(context())
        val messageTextView = messageView.adaptive_message_view_text

        var message = context().getString(
            R.string.adaptive_message_view_text
        )
        messageView.setMessageText(R.string.adaptive_message_view_text)
        Assert.assertEquals(
            message,
            messageTextView.text.toString()
        )

        message = "Test text!"
        messageView.setMessageText(message)
        Assert.assertEquals(
            message,
            messageTextView.text.toString()
        )
    }

}
