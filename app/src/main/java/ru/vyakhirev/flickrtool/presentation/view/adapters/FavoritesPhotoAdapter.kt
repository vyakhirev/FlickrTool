package ru.vyakhirev.flickrtool.presentation.view.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.photo_item.view.*
import ru.vyakhirev.flickrtool.R
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

class FavoritesPhotoAdapter(
    private val context: Context,
    private var photos: List<PhotoItem>,
    val bigPhotoClickListener: ((photo: PhotoItem) -> Unit)?,
    val favorStarClickListener:((photo: PhotoItem,pos:Int) -> Unit)?
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
        if(holder is ViewHolderPhotoItem)
            holder.itemView.favor_Star.setOnClickListener{
                favorStarClickListener?.invoke(photos[position],position)
            }
    }

    fun update(data: List<PhotoItem>) {
        photos = data
        Log.d("sar",photos.toString())
    }
}