package com.atdroid.atyurin.futuremoney.pages

import com.atdroid.atyurin.futuremoney.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.spinner.KSpinner

object BudgetItemFormScreen : KScreen<BudgetItemFormScreen>() {
    override val layoutId = R.layout.fragment_budget_item
    override val viewClass = Any::class.java

    val name = KEditText { withId(R.id.et_item_name_value) }
    val amount = KEditText { withId(R.id.et_item_amount_value) }
    val type = KSpinner({ withId(R.id.sp_item_type) }) {}
    val periodValue = KEditText { withId(R.id.et_period_value) }
    val periodType = KSpinner({ withId(R.id.sp_period_type_spinner) }) {}
    val save = KView { withId(R.id.action_btn_add_budget_item_confirm) }
}
