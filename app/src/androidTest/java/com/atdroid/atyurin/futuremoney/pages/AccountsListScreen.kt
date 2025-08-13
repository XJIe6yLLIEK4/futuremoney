package com.atdroid.atyurin.futuremoney.pages

import com.atdroid.atyurin.futuremoney.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

object AccountsListScreen : KScreen<AccountsListScreen>() {
    override val layoutId = R.layout.fragment_account_items_list
    override val viewClass = Any::class.java

    val fab = KView { withId(R.id.fab) }
    val listContainer = KView { withId(R.id.lv_budget_items) }

    fun assertItemVisible(text: String) {
        onView(withText(text)).check(matches(isDisplayed()))
    }
}
