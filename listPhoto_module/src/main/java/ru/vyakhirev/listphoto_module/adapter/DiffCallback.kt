package ru.vyakhirev.listphoto_module.adapter

import androidx.recyclerview.widget.DiffUtil

class DiffCallback(private val newRows: List<ru.vyakhirev.core_api.dto.PhotoItem>, private val oldRows: List<ru.vyakhirev.core_api.dto.PhotoItem>) :
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
