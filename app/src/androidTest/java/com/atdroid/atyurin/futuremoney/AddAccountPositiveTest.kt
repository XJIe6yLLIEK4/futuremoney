package com.atdroid.atyurin.futuremoney

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.atdroid.atyurin.futuremoney.activity.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atdroid.atyurin.futuremoney.pages.AccountFormScreen
import com.atdroid.atyurin.futuremoney.pages.AccountsListScreen
import com.atdroid.atyurin.futuremoney.pages.MainScreen

class AddAccountPositiveTest : TestCase() {
    @get:Rule val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addAccount_positive() = run {
        val accountName = "QA Account"
        val amount = "1000"

        step("Open Accounts screen") {
            MainScreen.openAccounts()
            AccountsListScreen { fab.isDisplayed() }
        }

        step("Create a new account") {
            AccountsListScreen.fab.click()
            AccountFormScreen.name.replaceText(accountName)
            AccountFormScreen.amount.replaceText(amount)
            onView(withId(R.id.action_btn_add_budget_item_confirm)).perform(click())
        }

        step("Verify account appears in the list") {
            AccountsListScreen.assertItemVisible(accountName)
        }
    }
}
