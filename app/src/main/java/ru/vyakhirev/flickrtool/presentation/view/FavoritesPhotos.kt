package ru.vyakhirev.flickrtool.presentation.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyakhirev.flickrtool.R
import ru.vyakhirev.flickrtool.presentation.viewmodel.FavoritesPhotosViewModel

class FavoritesPhotos : Fragment() {

    companion object {
        fun newInstance() = FavoritesPhotos()
    }

    private lateinit var viewModel: FavoritesPhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorites_photo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoritesPhotosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}