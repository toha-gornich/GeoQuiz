package com.cl.geoquiz
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.action.ViewActions.click
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var scenario: ActivityScenario<MainActivity>
    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun showsFirstQuestionOnLaunch() {
        //onView знаходить конкретний view
        //check перевіряє
        //On the view with the ID R.id.question_text_view, check that it matches the text from R.string.question_australia.
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_australia)))
    }

    @Test
    fun showsSecondQuestionAfterNextPress() {
        //onView знаходить конкретний view
        //perform виконує

        onView(withId(R.id.next_button)).perform(click())
        //onView знаходить конкретний view
        //check перевіряє
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_oceans)))
    }
    @Test
    fun handlesActivityRecreation() {
        onView(withId(R.id.next_button)).perform(click())
        scenario.recreate()
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_oceans)))
    }
}