package ru.vyakhirev.flickrtool.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vyakhirev.flickrtool.R

class FavoritesPhotosFragment : Fragment() {
//    init {
//        DaggerActivityComponent.builder()
//            .appComponent(App.instance!!.component)
//            .build()
//            .inject(this)
//    }
//
//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//
//    private lateinit var viewModel: FavoritesPhotosViewModel
//
//    private var favClickListener: ListPhotosFragment.OnPhotoClickListener? = null
//    private var favStarClickListener: ListPhotosFragment.OnPhotoClickListener? = null

//    private lateinit var adapter: FavoritesPhotoAdapter
//    interface OnPhotoClickListener {
//        fun onPhotoClick(photo: PhotoData)
//        fun onStarClick(photo: PhotoData,pos:Int)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorites_photo_fragment, container, false)


    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        Log.d("kann", "OnCreateView")
//
//        adapter =
//            FavoritesPhotoAdapter(
//                requireContext(),
//                listOf(),
//                bigPhotoClickListener = {
//                    val bundle = Bundle()
//                    bundle.apply {
//                        putString(ListPhotosFragment.IMAGE_URL, it.getFlickrImageLink('z'))
//                    }
//                    Navigation.findNavController(requireView())
//                        .navigate(R.id.BigPhotoFragment, bundle)
//                },
//                favorStarClickListener = { photo, pos ->
//                    Log.d("kann", "$pos +++ ${adapter.itemCount}")
//                    viewModel.switchFavorite(photo)
//                    Log.d("per", photo.toString())
//                    photo.isFavorite = !photo.isFavorite
//                    Log.d("per", photo.toString())
//                    adapter.notifyItemRemoved(pos)
////                    adapter.notifyDataSetChanged()
//                }
//            )
//        favoritesPhotoRV.layoutManager = GridLayoutManager(context, 2)
//        favoritesPhotoRV.adapter = adapter
//
////        viewModel = ViewModelProvider(
////            requireActivity(),
////            viewModelFactory
////        )[FavoritesPhotosViewModel::class.java]
//
////        viewModel.getFavorites()
//
////        viewModel.favPhotos.observe(
////            viewLifecycleOwner,
////            Observer<List<PhotoItem>> { adapter.update(it) })
////        setupRecyclerView()
////        setupViewModel()
//
//
//    }

//    private fun setupRecyclerView() {
//        adapter =
//            FavoritesPhotoAdapter(
//                requireContext(),
//                listOf(),
//                bigPhotoClickListener = {
//                    val bundle = Bundle()
//                    bundle.apply {
//                        putString(ListPhotosFragment.IMAGE_URL, it.getFlickrImageLink('z'))
//                    }
//                    Navigation.findNavController(requireView())
//                        .navigate(R.id.BigPhotoFragment, bundle)
//                },
//                favorStarClickListener = { photo, pos ->
//                    Log.d("kann", "$pos _______ $photo.toString() ")
//                    photo.isFavorite = !photo.isFavorite
//                    adapter.notifyItemRemoved(pos)
//                    viewModel.switchFavorite(photo)
////                    adapter.notifyDataSetChanged()
//                }
//            )
//        favoritesPhotoRV.layoutManager = LinearLayoutManager(context)
////        favoritesPhotoRV.layoutManager = GridLayoutManager(context, 2)
//        favoritesPhotoRV.adapter = adapter
//    }
//
//    private fun setupViewModel() {
//        viewModel = ViewModelProvider(
//            requireActivity(),
//            viewModelFactory
//        )[FavoritesPhotosViewModel::class.java]
//
//        viewModel.getFavorites()
//
//        viewModel.favPhotos.observe(
//            viewLifecycleOwner,
//            Observer<List<PhotoItem>> {
//                adapter.update(it)
//            })
//    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        if (activity is ListPhotosFragment.OnPhotoClickListener) {
//            favClickListener = activity as ListPhotosFragment.OnPhotoClickListener
//            favStarClickListener = activity as ListPhotosFragment.OnPhotoClickListener
//        } else {
//            throw Exception("Activity must implement ClickListener")
//        }
//    }
}
