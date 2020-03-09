package com.smlnskgmail.jaman.adaptiverecyclerview

import android.content.Context
import android.os.Build
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
abstract class BaseUITest {

    private val context = InstrumentationRegistry.getInstrumentation().context

    fun context(): Context {
        return context
    }

}
