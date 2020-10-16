package ru.vyakhirev.listphoto_module

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PhotosRecyclerViewTest {

//    @get:Rule
//    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

//    onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItem(hasDescendant(withId(viewId)), click()))

    @Test
    fun checkClickOnPhoto() {
        launchFragmentInContainer<ListPhotosFragment>()
        onView(withId(R.id.listPhotoRV))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(
                        withId(
                            R.id.photo_IV
                        )
                    ), click()
                )
            )
    }
}