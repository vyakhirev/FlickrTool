package ru.vyakhirev.listphoto_module

import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class PhotosRecyclerViewTest {

//    @get:Rule
//    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private fun clickOnViewChild(viewId: Int) = object : ViewAction {
        override fun getConstraints() = null

        override fun getDescription() = "Click on a child view with specified id."

        override fun perform(uiController: UiController, view: View) =
            ViewActions.click().perform(uiController, view.findViewById<View>(viewId))
    }

    @Test
    fun checkRecyclerViewDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.listPhotoRV))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkClickOnPhoto() {
        launchFragmentInContainer<ListPhotosFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.listPhotoRV))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    clickOnViewChild(R.id.photo_IV)
                )
            )

        Espresso.onView(ViewMatchers.withId(R.id.bigPhotoFragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}