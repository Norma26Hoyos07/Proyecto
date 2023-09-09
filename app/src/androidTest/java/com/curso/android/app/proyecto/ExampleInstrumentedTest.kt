package com.curso.android.app.proyecto

import com.curso.android.app.proyecto.vista.MainActivity

import androidx.test.ext.junit.rules.ActivityScenarioRule
import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var rule:ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)
    @RunWith(AndroidJUnit4::class)
    @LargeTest
    class ChangeTextBehaviorKtTest {

        /**
         * Use [ActivityScenarioRule] to create and launch the activity under test before each test,
         * and close it after each test. This is a replacement for
         * [androidx.test.rule.ActivityTestRule].
         */
        @get:Rule
        var rule:ActivityScenarioRule<*> = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

        @Test
        fun comprobarVacias() {

            // hacer click en boton sin llenar textos
            onView(withId(R.id.boton))
                .perform(click())

            // vemos que cambie el resultado
            onView(withId(R.id.resultado)).check(matches(withText(vacias)))


        }
        @Test
        fun comprobariguales() {

            // hacer click en boton sin llenar textos
           onView(withId(R.id.palabra1)).perform(typeText("texto"),
               closeSoftKeyboard())
           onView(withId(R.id.palabra2)).perform(typeText("texto"),
               closeSoftKeyboard())
            onView(withId(R.id.boton))
                .perform(click())

            // vemos que cambie el resultado
            onView(withId(R.id.resultado)).check(matches(withText(iguales)))


        }

        @Test
        fun comprobardistintos() {

            // hacer click en boton sin llenar textos
            onView(withId(R.id.palabra1)).perform(typeText("texto1"),
                closeSoftKeyboard())
            onView(withId(R.id.palabra2)).perform(typeText("texto"),
                closeSoftKeyboard())
            onView(withId(R.id.boton))
                .perform(click())

            // vemos que cambie el resultado
            onView(withId(R.id.resultado)).check(matches(withText(distintas)))


        }

        companion object {

            val vacias = "estan vacias"
            val iguales= "Son iguales"
            val distintas="Son distintas"
        }


    }}