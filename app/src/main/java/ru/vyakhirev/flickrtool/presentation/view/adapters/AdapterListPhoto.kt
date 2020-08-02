package ru.vyakhirev.flickrtool.presentation.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_item.view.*
import ru.vyakhirev.flickrtool.R
import ru.vyakhirev.flickrtool.data.model.Photo

class AdapterListPhoto(
    private val context: Context,
    private var photos: List<Photo>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderPhotoItem(
            LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false)
        )
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderPhotoItem)
            holder.bind(photos[position])
    }

    fun update(data: List<Photo>) {
        photos = data
        notifyDataSetChanged()
    }
}

class ViewHolderPhotoItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Photo) {

        Glide.with(itemView)
            .load(item.getImageUrl())
            .centerCrop()
            .into(itemView.photo_IV)

        itemView.title_TV.text = item.title
    }
}
