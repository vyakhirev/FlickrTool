package ru.vyakhirev.listphoto_module.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.photo_item.view.*
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.listphoto_module.R

class ViewHolderPhotoItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: PhotoItem) {
        itemView.photo_IV.loadImageFromLink(item.getFlickrImageLink())
//        if (item.width_n.isNullOrEmpty())
//            itemView.photo_IV.setHeightRatio(calculateHeightRatio(item.width_n!!, item.height_n!!))

        itemView.title_TV.setTextColor(Color.parseColor("#0972C5"))
        itemView.title_TV.text = item.title
        itemView.favor_Star.setImageResource(if (item.isFavorite)
            R.drawable.ic_star_on else R.drawable.ic_star_off
        )
    }
    fun ImageView.loadImageFromLink(link: String?) {
        if (!link.isNullOrEmpty()) {
            Glide.with(context.applicationContext)
                .load(link)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(this)
        }
    }

    private fun calculateHeightRatio(width_n: String, height_n: String): Float {
        val w = width_n.toInt()
        val h = height_n.toInt()

        return (h.toFloat() / w.toFloat())
    }

}