package com.smlnskgmail.jaman.adaptiverecyclerview

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseUITest {

    private val context = InstrumentationRegistry.getInstrumentation().context

    fun context(): Context {
        return context
    }

}
