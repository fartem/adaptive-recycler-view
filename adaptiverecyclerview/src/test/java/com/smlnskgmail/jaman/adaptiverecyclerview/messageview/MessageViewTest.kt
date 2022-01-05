package com.smlnskgmail.jaman.adaptiverecyclerview.messageview

import android.util.AttributeSet
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveMessageView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import com.smlnskgmail.jaman.adaptiverecyclerview.R
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric

class MessageViewTest : BaseUITest() {

    private lateinit var attrs: AttributeSet
    private lateinit var emptyAttrs: AttributeSet

    @Before
    fun setup() {
        attrs = Robolectric.buildAttributeSet()
            .addAttribute(
                R.attr.message_image,
                "@drawable/ic_adaptive_message_view_image"
            )
            .addAttribute(
                R.attr.message_text,
                "@string/adaptive_message_view_text"
            )
            .addAttribute(
                R.attr.message_text_at_center,
                "true"
            )
            .build()

        assertNotNull(attrs)

        emptyAttrs = Robolectric.buildAttributeSet().build()
        assertNotNull(emptyAttrs)
    }

    @Test
    fun checkConstructorWithoutAttrs() {
        AdaptiveMessageView(context())
    }

    @Test
    fun checkConstructorsWithAttrs() {
        AdaptiveMessageView(
            context(),
            attrs
        )
        AdaptiveMessageView(
            context(),
            attrs,
            0
        )
    }

    @Test
    fun checkConstructorsWithEmptyAttrs() {
        AdaptiveMessageView(
            context(),
            emptyAttrs
        )
        AdaptiveMessageView(
            context(),
            emptyAttrs,
            0
        )
    }

    @Test
    fun checkConstructorsWithNullAttrs() {
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

}
