package ru.vyakhirev.favorphoto_module

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavorClickTest {

    @Test
    private fun clickOnViewChild(viewId: Int) = object : ViewAction {
        override fun getConstraints() = null

        override fun getDescription() = "Click on a child view with specified id."

        override fun perform(uiController: UiController, view: View) =
            ViewActions.click().perform(uiController, view.findViewById<View>(viewId))
    }

//    @Test
//    fun testEqualInFavor() {
//        val scenarioFavor = launchFragmentInContainer<FavoritePhotosFragment>()
//
//        scenarioFavor.onFragment {
//            val expectedText = ""
//            val actualText = R.id.title_TV .text.toString()
//
//            Assert.assertEquals(expectedText, actualText)
//        }
//    }

}