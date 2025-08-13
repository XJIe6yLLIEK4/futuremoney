package com.atdroid.atyurin.futuremoney.pages

import com.atdroid.atyurin.futuremoney.R
import com.atdroid.atyurin.futuremoney.activity.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.toolbar.KToolbar
import io.github.kakaocup.kakao.common.views.KView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText

object MainScreen : KScreen<MainScreen>() {
    override val layoutId = R.layout.activity_main
    override val viewClass = MainActivity::class.java

    val toolbar = KToolbar { withId(R.id.toolbar) }
    fun openDrawer() = KView { withContentDescription(R.string.navigation_drawer_open) }.click()

    fun openAccounts() { openDrawer(); onView(withText(R.string.title_section_accounts)).perform(click()) }
    fun openIncomes()  { openDrawer(); onView(withText(R.string.title_section_incomes)).perform(click()) }
    fun openTotals()   { openDrawer(); onView(withText(R.string.title_section_totals)).perform(click()) }
    fun openMenuItemOutcomes() { openDrawer(); onView(withText(R.string.title_section_outcomes)).perform(click()) }
}
