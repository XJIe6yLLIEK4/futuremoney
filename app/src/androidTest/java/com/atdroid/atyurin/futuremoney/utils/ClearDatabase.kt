package com.atdroid.atyurin.futuremoney.utils

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ClearDatabase : TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        context.deleteDatabase("FutureMoneyDB")

        val sharedPreferences = context.getSharedPreferences("default_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
    }
}
