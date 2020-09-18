package ru.vyakhirev.favorphoto_module.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.photo_item.view.*
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.favorphoto_module.R

class FavoritesPhotoAdapter(
    private val context: Context,
    private var photos: MutableList<PhotoItem>,
    val bigPhotoClickListener: ((photo: PhotoItem) -> Unit)?,
    val favorStarClickListener: ((photo: PhotoItem) -> Unit)?
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

        if (holder is ViewHolderPhotoItem)
            holder.itemView.photo_IV.setOnClickListener {
                bigPhotoClickListener?.invoke(photos[position])
            }
        if (holder is ViewHolderPhotoItem)
            holder.itemView.favor_Star.setOnClickListener {
                favorStarClickListener?.invoke(photos[position])
            }
    }

    fun addItems(items: MutableList<PhotoItem?>) {
        items.addAll(items)
    }

    fun update(data: MutableList<PhotoItem>) {
//        val movieDiffUtilCallback = DiffCallback(photos, data)
//        val diffResult = DiffUtil.calculateDiff(movieDiffUtilCallback)
        photos = data
        notifyDataSetChanged()
//        diffResult.dispatchUpdatesTo(this)
    }
}