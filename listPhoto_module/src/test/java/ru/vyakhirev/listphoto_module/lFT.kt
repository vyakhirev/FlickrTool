package ru.vyakhirev.listphoto_module

//@RunWith(RobolectricTestRunner::class)
//@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
//class MyFragmentTest {
//
//    lateinit var fragment: ListPhotosFragment
//    lateinit var activityController: ActivityController<FragmentActivity>
//
//    @Before
//    @Throws(Exception::class)
//    fun setUp() {
//        fragment = ListPhotosFragment()
//
//        activityController = Robolectric.buildActivity(FragmentActivity::class.java)
//
//        activityController.create().start().resume()
//
//        activityController.get()
//            .supportFragmentManager
//            .beginTransaction()
//            .add(fragment, null)
//            .commit()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun testClickEntry() {
//        val recycler = fragment.view!!.findViewById(R.id.listPhotoRV) as RecyclerView
//         workaround robolectric recyclerView issue
//        recycler.measure(0, 0)
//        recycler.layout(0, 0, 100, 1000)
//
//         lets just imply a certain item at position 0 for simplicity
//        (recycler.findViewHolderForAdapterPosition(0)!!.itemView.title_TV as TextView).text = "Moon"
//
//         presenter is injected in my case, how this verification happens depends on how you manage your dependencies.
//        verify(fragment).
//    }
//}