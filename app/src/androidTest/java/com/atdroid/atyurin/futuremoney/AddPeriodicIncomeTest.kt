package com.atdroid.atyurin.futuremoney

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.atdroid.atyurin.futuremoney.activity.MainActivity
import com.atdroid.atyurin.futuremoney.pages.BudgetItemFormScreen
import com.atdroid.atyurin.futuremoney.pages.BudgetItemsPagerScreen
import com.atdroid.atyurin.futuremoney.pages.MainScreen
import com.atdroid.atyurin.futuremoney.utils.ClearDatabase
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.hamcrest.Matchers.allOf
import org.hamcrest.CoreMatchers.anything
import org.junit.Rule
import org.junit.Test

class AddPeriodicIncomeTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val clearDatabase = ClearDatabase()

    @Test
    fun addPeriodicIncome_and_see_it_in_periodic_tab() = run {
        val itemName = "Salary"
        val itemAmount = "123"

        step("Open Incomes -> Periodic tab") {
            MainScreen.openIncomes()
            BudgetItemsPagerScreen.openPeriodicTab()
        }

        step("Create periodic income") {
            BudgetItemsPagerScreen.fab.click()

            BudgetItemFormScreen.run {
                name.replaceText(itemName)
                amount.replaceText(itemAmount)
            }

            onView(withId(R.id.sp_item_type)).perform(click())
            onData(anything()).atPosition(1).perform(click())

            BudgetItemFormScreen.periodValue.replaceText("1")

            onView(withId(R.id.action_btn_add_budget_item_confirm))
                .check(matches(isDisplayed()))
                .perform(click())
        }

        step("Verify it appears in Periodic list") {
            val visibleList = allOf(withId(R.id.lv_budget_items), isCompletelyDisplayed())

            onView(
                allOf(
                    withId(R.id.tv_budget_item_name),
                    withText(itemName),
                    isDescendantOfA(visibleList)
                )
            ).check(matches(isDisplayed()))

            onView(
                allOf(
                    withId(R.id.tv_budget_item_value),
                    withText(itemAmount),
                    isDescendantOfA(visibleList)
                )
            ).check(matches(isDisplayed()))
        }
    }
}
