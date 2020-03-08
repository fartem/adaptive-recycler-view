package com.smlnskgmail.jaman.adaptiverecyclerview.messageview

import androidx.core.content.ContextCompat
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveMessageView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import com.smlnskgmail.jaman.adaptiverecyclerview.R
import kotlinx.android.synthetic.main.view_adaptive_message.view.*
import org.junit.Assert.assertEquals
import org.junit.Test

class MessageViewTest : BaseUITest() {

    @Test
    fun checkConstructors() {
        AdaptiveMessageView(
            context()
        )
        AdaptiveMessageView(
            context(),
            null
        )
        AdaptiveMessageView(
            context(),
            null,
            0
        )
    }

    @Test
    fun checImageSetup() {
        val messageView =
            AdaptiveMessageView(
                context()
            )

        messageView.setImage(
            R.drawable.ic_adaptive_message_view_image
        )
        messageView.setImage(
            ContextCompat.getDrawable(
                context(),
                R.drawable.ic_adaptive_message_view_image
            )!!
        )
    }

    @Test
    fun checTextSetup() {
        val messageView =
            AdaptiveMessageView(
                context()
            )
        val messageTextView = messageView.adaptive_message_view_text

        var message = context().getString(
            R.string.adaptive_message_view_text
        )
        messageView.setMessageText(
            R.string.adaptive_message_view_text
        )
        assertEquals(
            message,
            messageTextView.text.toString()
        )

        message = "Test text!"
        messageView.setMessageText(
            message
        )
        assertEquals(
            message,
            messageTextView.text.toString()
        )
    }

}
