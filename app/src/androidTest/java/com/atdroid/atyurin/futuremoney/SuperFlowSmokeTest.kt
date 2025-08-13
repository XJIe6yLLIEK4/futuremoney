package com.atdroid.atyurin.futuremoney

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.atdroid.atyurin.futuremoney.activity.MainActivity
import com.atdroid.atyurin.futuremoney.pages.*
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import org.hamcrest.Matchers.anyOf
import com.atdroid.atyurin.futuremoney.utils.ClearDatabase
import org.hamcrest.Matchers.anything

class SuperFlowSmokeTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val clearDatabase = ClearDatabase()

    @Test
    fun mainFlow_addAccount_expense_income_and_checkTotalsUI() = run {
        val accName = "Wallet"
        val accAmount = "500"
        val incomeName = "Bonus"
        val incomeAmount = "200"
        val outcomeName = "Groceries"
        val outcomeAmount = "50"

        step("Add account") {
            MainScreen.openAccounts()
            AccountsListScreen.fab.click()
            AccountFormScreen.name.replaceText(accName)
            AccountFormScreen.amount.replaceText(accAmount)
            onView(withId(R.id.action_btn_add_budget_item_confirm)).perform(click())
        }

        step("Add one expense (Single)") {
            MainScreen.openDrawer()
            MainScreen.openMenuItemOutcomes()
            BudgetItemsPagerScreen.fab.click()
            BudgetItemFormScreen.name.replaceText(outcomeName)
            BudgetItemFormScreen.amount.replaceText(outcomeAmount)
            onView(withId(R.id.sp_item_type)).perform(click())
            onData(anything()).atPosition(0).perform(click())   // Single
            onView(withId(R.id.action_btn_add_budget_item_confirm)).perform(click())
        }

        step("Add one income (Periodic)") {
            MainScreen.openIncomes()
            BudgetItemsPagerScreen.openPeriodicTab()
            BudgetItemsPagerScreen.fab.click()
            BudgetItemFormScreen.name.replaceText(incomeName)
            BudgetItemFormScreen.amount.replaceText(incomeAmount)
            onView(withId(R.id.sp_item_type)).perform(click())
            onData(anything()).atPosition(1).perform(click())   // Periodic
            try { BudgetItemFormScreen.periodValue.replaceText("1") } catch (_: Throwable) {}
            onView(withId(R.id.action_btn_add_budget_item_confirm)).perform(click())
        }

        step("Open Totals and verify UI elements visible") {
            MainScreen.openTotals()
            TotalsScreen.btnCalc.isDisplayed()
            TotalsScreen.btnCalc.click()

            TotalsScreen.valuesBlock.isDisplayed()
            TotalsScreen.accountsTotal.isDisplayed()
            TotalsScreen.incomesTotal.isDisplayed()
            TotalsScreen.outcomesTotal.isDisplayed()
            TotalsScreen.total.isDisplayed()

            onView(withId(R.id.graph_view_totals))
                .check(
                    matches(
                        anyOf(
                            isDisplayed(),
                            withEffectiveVisibility(Visibility.GONE)
                        )
                    )
                )
        }
    }
}
