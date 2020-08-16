package ru.vyakhirev.flickrtool.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject
import kotlinx.android.synthetic.main.listphoto_fragment.*
import ru.vyakhirev.flickrtool.App
import ru.vyakhirev.flickrtool.R
import ru.vyakhirev.flickrtool.data.model.PhotoData
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.di.components.DaggerActivityComponent
import ru.vyakhirev.flickrtool.presentation.view.adapters.AdapterListPhoto
import ru.vyakhirev.flickrtool.presentation.viewmodel.ListPhotosViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListPhotosFragment : Fragment() {

    companion object {
        const val IMAGE_URL = "image_url"
    }

    init {
        DaggerActivityComponent.builder()
            .appComponent(App.instance!!.component)
            .build()
            .inject(this)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: ListPhotosViewModel

    private lateinit var adapter: AdapterListPhoto
    private var favClickListener: OnPhotoClickListener? = null

    interface OnPhotoClickListener {
        fun onPhotoClick(photo: PhotoData)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.listphoto_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter =
            AdapterListPhoto(
                requireContext(),
                mutableListOf(),
                bigPhotoClickListener = {
                    val bundle = Bundle()
                    bundle.apply {
                        putString(IMAGE_URL, it.getFlickrImageLink('z'))
                    }
                    Navigation.findNavController(view).navigate(R.id.BigPhotoFragment, bundle)
                }
            )
        listPhotoRV.layoutManager = GridLayoutManager(context, 2)
        listPhotoRV.adapter = adapter

        val itemDecor = CustomItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
//        ContextCompat.getDrawable(requireContext(), R.drawable.divider)
//            ?.let { itemDecor.setDrawable(it) }
        listPhotoRV.addItemDecoration(itemDecor)

        listPhotoRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if ((recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == (viewModel.photos.value?.size?.minus(
                        1
                    ))
                ) {
                    viewModel.page++
                    viewModel.getPhoto("birds")
                }
            }
        })

        viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        )[ListPhotosViewModel::class.java]

        viewModel.getPhoto("Moscow Cremlin")

        viewModel.photos.observe(
            viewLifecycleOwner,
            Observer<MutableList<PhotoItem>> { adapter.update(it) })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity is OnPhotoClickListener) {
            favClickListener = activity as OnPhotoClickListener
        } else {
            throw Exception("Activity must implement ClickListener")
        }
    }
}
