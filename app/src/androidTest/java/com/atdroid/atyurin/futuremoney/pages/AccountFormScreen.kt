package com.atdroid.atyurin.futuremoney.pages

import com.atdroid.atyurin.futuremoney.R
import io.github.kakaocup.kakao.edit.KEditText
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView

object AccountFormScreen : KScreen<AccountFormScreen>() {
    override val layoutId: Int = R.layout.fragment_account_item
    override val viewClass: Class<*> = Any::class.java

    val name = KEditText { withId(R.id.et_account_name_value) }
    val amount = KEditText { withId(R.id.et_account_amount_value) }
    val save = KView { withId(R.id.action_btn_add_budget_item_confirm) }
}
