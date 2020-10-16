package ru.vyakhirev.listphoto_module

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import ru.vyakhirev.listphoto_module.adapter.ViewHolderPhotoItem

@RunWith(AndroidJUnit4::class)
@Config(application = TestApp::class)
class FavorClickTest {

    private fun clickOnViewChild(viewId: Int) = object : ViewAction {
        override fun getConstraints() = null

        override fun getDescription() = "Click on a child view with specified id."

        override fun perform(uiController: UiController, view: View) =
            ViewActions.click().perform(uiController, view.findViewById<View>(viewId))

    }

    @Test
    fun testFavoritesAdd() {

        Espresso.onView(withId(R.id.listPhotoRV))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ViewHolderPhotoItem>(
                    1,
                    clickOnViewChild(R.id.favor_Star)
                )
            )

//        Espresso.onView(withId(R.id.listPhotoRV))
//            .

    }


}