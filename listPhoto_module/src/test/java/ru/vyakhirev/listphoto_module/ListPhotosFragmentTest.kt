package ru.vyakhirev.listphoto_module

import android.os.Build
import android.os.Looper
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.photo_item.view.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.dto.PhotoResult
import ru.vyakhirev.listphoto_module.utils.DataGenerator
import ru.vyakhirev.listphoto_module.utils.RxRule
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApp::class, sdk = [Build.VERSION_CODES.O_MR1])
class ListPhotosFragmentTest {

    @get:Rule
    val rxRule = RxRule()

    var mockWebServer: MockWebServer = MockWebServer()

    private lateinit var dummyList: List<PhotoItem>
    private lateinit var dummyPhotoResult: PhotoResult


    lateinit var fragment: ListPhotosFragment

    lateinit var activityController: ActivityController<FragmentActivity>

//    private fun clickOnViewChild(viewId: Int) = object : ViewAction {
//        override fun getConstraints() = null
//
//        override fun getDescription() = "Click on a child view with specified id."
//
//        override fun perform(uiController: UiController, view: View) =
//            ViewActions.click().perform(uiController, view.findViewById<View>(viewId))
//    }


    @Before
    fun setUp() {
        dummyList = DataGenerator.getDummyGalleryList(35)
        dummyPhotoResult = PhotoResult(1, 3, 30, 90, dummyList as MutableList<PhotoItem>)
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(getBody())
            .setBodyDelay(0, TimeUnit.MILLISECONDS)

        mockWebServer.enqueue(response)
        mockWebServer.start(8090)

        fragment = ListPhotosFragment()

//        launchFragmentInContainer<ListPhotosFragment>()
        activityController = Robolectric.buildActivity(FragmentActivity::class.java)

        activityController.create().start().resume()

        activityController.get()
            .supportFragmentManager
            .beginTransaction()
            .add(fragment, null)
            .commit()
    }

    private fun getBody(): String {
        return dummyPhotoResult.toString()
    }

    @After
    fun clear() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should load photo title into title_TV`() {
        shadowOf(Looper.getMainLooper()).idle()
        val recycler = fragment.view!!.findViewById(R.id.listPhotoRV) as RecyclerView
        // workaround robolectric recyclerView issue
        recycler.measure(0, 0)
        recycler.layout(0, 0, 100, 1000)

        val expected = "full moon"
        assertEquals(
            expected,
            (recycler.findViewHolderForAdapterPosition(0)!!.itemView.title_TV as TextView).text
        )
    }

//    @Test
//    fun `should load image address`(){
//        shadowOf(Looper.getMainLooper()).idle()
//        val recycler = fragment.view!!.findViewById(R.id.listPhotoRV) as RecyclerView
//
//        recycler.measure(0, 0)
//        recycler.layout(0, 0, 100, 1000)
//
//        assertEquals(imageUrl,)
//    }

//    @Test
//    fun testBuilder_Fragment() {
//        val activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
//        val fragment=launchFragmentInContainer<ListPhotosFragment>(themeResId = R.style.Theme_AppCompat).moveToState(
//            Lifecycle.State.RESUMED)
//        val recycler = (R.id.listPhotoRV) as RecyclerView
//        recycler.findViewHolderForAdapterPosition(0)!!.itemView.title_TV
//        assertEquals(
//            (activity.findViewById(R.id.title_TV) as TextView).text.toString(),
//            "Moon"
//        )
//    }

}