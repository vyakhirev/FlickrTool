package ru.vyakhirev.flickrtool.presentation.view.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_item.view.*
import ru.vyakhirev.flickrtool.R
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

class AdapterListPhoto(
    private val context: Context,
    private var photos: MutableList<PhotoItem>,
    val bigPhotoClickListener: ((photo: PhotoItem) -> Unit)?
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
    }
    fun addItems(items: MutableList<PhotoItem?>) {
        items.addAll(items)
    }
    fun update(data: MutableList<PhotoItem>) {
        val movieDiffUtilCallback = DiffCallback(photos, data)
        val diffResult = DiffUtil.calculateDiff(movieDiffUtilCallback)
        photos = data
        diffResult.dispatchUpdatesTo(this)
    }
}

class ViewHolderPhotoItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: PhotoItem) {
        Glide.with(itemView)
            .load(item.getFlickrImageLink())
            .centerCrop()
            .into(itemView.photo_IV)

        itemView.title_TV.setTextColor(Color.parseColor("#0972C5"))
        itemView.title_TV.text = item.title
    }
}
