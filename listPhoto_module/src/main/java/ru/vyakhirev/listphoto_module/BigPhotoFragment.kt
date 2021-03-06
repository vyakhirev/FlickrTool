package ru.vyakhirev.listphoto_module

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.big_photo_fragment.*

class BigPhotoFragment : Fragment() {

    companion object {
        private const val URL = "image_url"
        fun newInstance()=BigPhotoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.big_photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(URL)
        Log.d("Kadddn", "url=$url ")
        Glide.with(bigPhotoIV)
            .load(arguments?.getString(URL))
            .centerCrop()
            .into(bigPhotoIV)
    }
}