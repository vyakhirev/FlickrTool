package ru.vyakhirev.listphoto_module

import android.os.Build
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(application = TestApp::class, sdk = [Build.VERSION_CODES.O_MR1])
class SampleFragmentTest {
    @Test
    fun launchFragmentAndVerifyUI() {
        // use launchInContainer to launch the fragment with UI
        launchFragmentInContainer<ListPhotosFragment>()

        // now use espresso to look for the fragment's text view and verify it is displayed
        Espresso.onView(withId(R.id.favor_Star))
            .check(ViewAssertions.matches(ViewMatchers.hasContentDescription()));
    }
}
