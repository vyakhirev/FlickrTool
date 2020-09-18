package ru.vyakhirev.favorphoto_module.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_item.view.*
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.favorphoto_module.R

class ViewHolderPhotoItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: PhotoItem) {
        Glide.with(itemView)
            .load(item.getFlickrImageLink())
            .centerCrop()
            .into(itemView.photo_IV)

        itemView.title_TV.setTextColor(Color.parseColor("#0972C5"))
        itemView.title_TV.text = item.title
        itemView.favor_Star.setImageResource(if (item.isFavorite)
            R.drawable.ic_star_on else R.drawable.ic_star_off
        )
    }
}