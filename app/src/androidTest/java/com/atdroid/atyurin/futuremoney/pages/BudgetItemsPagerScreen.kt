package com.atdroid.atyurin.futuremoney.pages

import com.atdroid.atyurin.futuremoney.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.matcher.ViewMatchers.withId

object BudgetItemsPagerScreen : KScreen<BudgetItemsPagerScreen>() {
    override val layoutId = R.layout.budget_item_view_pager
    override val viewClass = Any::class.java

    val pager = KView { withId(R.id.view_pager) }
    val tabStrip = KView { withId(R.id.view_pager_title_strip) }
    val fab = KView { withId(R.id.fab) }

    fun openPeriodicTab() {
        try { KTextView { withText("Periodic") }.click() }
        catch (_: Throwable) { onView(withId(R.id.view_pager)).perform(swipeLeft()) }
    }
}
