package com.smlnskgmail.jaman.adaptiverecyclerview.messageview

import android.util.AttributeSet
import com.smlnskgmail.jaman.adaptiverecyclerview.AdaptiveMessageView
import com.smlnskgmail.jaman.adaptiverecyclerview.BaseUITest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric

class MessageViewTest : BaseUITest() {

    private lateinit var attrs: AttributeSet

    @Before
    fun setup() {
        attrs = Robolectric.buildAttributeSet()
            .build()

        assertNotNull(
            attrs
        )
    }

    @Test
    fun checkConstructors() {
        AdaptiveMessageView(
            context()
        )
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

}
