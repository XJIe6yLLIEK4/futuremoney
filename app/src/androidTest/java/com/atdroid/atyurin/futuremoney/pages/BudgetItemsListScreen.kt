package com.atdroid.atyurin.futuremoney.pages

import com.atdroid.atyurin.futuremoney.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.common.views.KView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

object BudgetItemsListScreen : KScreen<BudgetItemsListScreen>() {
    override val layoutId = R.layout.fragment_budget_items_list
    override val viewClass = Any::class.java

    val empty = KTextView { withId(R.id.tv_no_data_found) }
    val listContainer = KView { withId(R.id.lv_budget_items) }

    fun assertItemVisible(text: String) {
        onView(withText(text)).check(matches(isDisplayed()))
    }
}
