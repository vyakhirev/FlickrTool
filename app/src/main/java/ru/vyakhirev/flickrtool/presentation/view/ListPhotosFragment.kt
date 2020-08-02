package ru.vyakhirev.flickrtool.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.listphoto_fragment.*
import ru.vyakhirev.flickrtool.R
import ru.vyakhirev.flickrtool.data.model.Photo
import ru.vyakhirev.flickrtool.presentation.view.adapters.AdapterListPhoto
import ru.vyakhirev.flickrtool.presentation.viewmodel.ListPhotosViewModel
import ru.vyakhirev.flickrtool.presentation.viewmodel.factory.ViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListPhotosFragment : Fragment() {

    lateinit var viewModel: ListPhotosViewModel
    private lateinit var adapter: AdapterListPhoto

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.listphoto_fragment, container, false)
    }

//    override fun onResume() {
//        super.onResume()
//        viewModel.getPhoto()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter =
            AdapterListPhoto(
                requireContext(),
                listOf()
            )
        listPhotoRV.layoutManager = LinearLayoutManager(context)
        listPhotoRV.adapter = adapter

        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory()
        ).get(ListPhotosViewModel::class.java)

        viewModel.getPhoto()

        viewModel.photos.observe(viewLifecycleOwner, Observer<List<Photo>> { adapter.update(it) })
//
//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }
}
