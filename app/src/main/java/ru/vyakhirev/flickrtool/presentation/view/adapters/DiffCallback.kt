package ru.vyakhirev.flickrtool.presentation.view.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

class DiffCallback(private val newRows: List<PhotoItem>, private val oldRows: List<PhotoItem>) :
    DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow.title == newRow.title
    }

    override fun getOldListSize(): Int = oldRows.size

    override fun getNewListSize(): Int = newRows.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow == newRow
    }
}
