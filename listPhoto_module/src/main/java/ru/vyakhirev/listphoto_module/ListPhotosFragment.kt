package ru.vyakhirev.listphoto_module

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listphoto_fragment.*
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.mediator.AppWithFacade
import ru.vyakhirev.listphoto_module.adapter.ListPhotoAdapter
import ru.vyakhirev.listphoto_module.di.EagerTrigger
import ru.vyakhirev.listphoto_module.di.ListPhotoComponent
import ru.vyakhirev.listphoto_module.viewmodel.ListPhotosViewModel
import javax.inject.Inject

class ListPhotosFragment : Fragment() {

    companion object {
        const val IMAGE_URL = "image_url"
    }

    private lateinit var adapter: ListPhotoAdapter
    private lateinit var viewModel: ListPhotosViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var eagerTrigger: EagerTrigger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ListPhotoComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(ListPhotosViewModel::class.java)

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
            ListPhotoAdapter(
                requireContext(),
                mutableListOf(),
                bigPhotoClickListener = {
                    val bundle = Bundle()
                    bundle.apply {
                        putString(IMAGE_URL, it.getFlickrImageLink('z'))
                    }
//                    Navigation.findNavController(view).navigate(R.id.BigPhotoFragment, bundle)
                },
                favorStarClickListener = {
                    Log.d("volttier", it.title!!)
                    it.isFavorite = !it.isFavorite
//                    viewModel.switchFavorite(it)
                    adapter.notifyDataSetChanged()
                }
            )
        listPhotoRV.layoutManager = GridLayoutManager(context, 2)
        listPhotoRV.adapter = adapter

//        val itemDecor = CustomItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
//        ContextCompat.getDrawable(requireContext(), R.drawable.divider)
//            ?.let { itemDecor.setDrawable(it) }
//        listPhotoRV.addItemDecoration(itemDecor)

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
        viewModel.getPhoto("Elefant")
        viewModel.photos.observe(
            viewLifecycleOwner,
            Observer<MutableList<PhotoItem>> { adapter.update(it) })
    }

}