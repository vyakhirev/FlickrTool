package ru.vyakhirev.flickrtool.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import ru.vyakhirev.flickrtool.R

@GlideModule
class CustomGlideModule : AppGlideModule()

const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500"
fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(POSTER_BASE_URL + uri)
        .into(this)
}
