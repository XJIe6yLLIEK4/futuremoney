package com.atdroid.atyurin.futuremoney.pages

import com.atdroid.atyurin.futuremoney.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView

object TotalsScreen : KScreen<TotalsScreen>() {
    override val layoutId = R.layout.fragment_totals
    override val viewClass = Any::class.java

    val btnCalc = KView { withId(R.id.action_btn_calc_totals) }
    val valuesBlock = KView { withId(R.id.ll_totals_values) }
    val accountsTotal = KView { withId(R.id.tv_accounts_total_value) }
    val incomesTotal = KView { withId(R.id.tv_incomes_total_value) }
    val outcomesTotal = KView { withId(R.id.tv_outcomes_total_value) }
    val total = KView { withId(R.id.tv_total_value) }
    val graph = KView { withId(R.id.graph_view_totals) }
}
