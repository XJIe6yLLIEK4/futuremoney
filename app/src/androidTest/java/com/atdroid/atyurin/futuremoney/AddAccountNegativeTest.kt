package com.atdroid.atyurin.futuremoney

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.atdroid.atyurin.futuremoney.activity.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.click
import com.atdroid.atyurin.futuremoney.utils.ToastMatcher
import com.atdroid.atyurin.futuremoney.pages.AccountFormScreen
import com.atdroid.atyurin.futuremoney.pages.AccountsListScreen
import com.atdroid.atyurin.futuremoney.pages.MainScreen
import com.atdroid.atyurin.futuremoney.utils.ClearDatabase

class AddAccountNegativeTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val clearDatabase = ClearDatabase()

    @Test
    fun addAccount_negative_emptyFields() = run {
        step("Open Accounts and open create form") {
            MainScreen.openAccounts()
            AccountsListScreen.fab.click()
        }

        step("Try to save with empty fields -> expect name toast") {
            onView(withId(R.id.action_btn_add_budget_item_confirm)).perform(click())
            onView(withText(R.string.msg_budget_item_empty_name))
                .inRoot(ToastMatcher())
                .check(matches(isDisplayed()))
        }

        step("Fill only name, leave amount empty -> expect amount toast") {
            AccountFormScreen.name {
                replaceText("Broken")
                hasText("Broken")
            }
            onView(withId(R.id.et_account_name_value)).check(matches(withText("Broken")))

            onView(withId(R.id.action_btn_add_budget_item_confirm)).perform(click())

            flakySafely(timeoutMs = 5000, intervalMs = 250) {
                onView(withText(R.string.msg_budget_item_empty_amount))
                    .inRoot(ToastMatcher())
                    .check(matches(isDisplayed()))
            }
        }
    }
}
