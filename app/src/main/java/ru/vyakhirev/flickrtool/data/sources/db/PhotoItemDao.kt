package ru.vyakhirev.flickrtool.data.sources.db

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface PhotoItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleItem(photoItem: PhotoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleItem(photoItemList: List<PhotoItem>)

    @Query("SELECT * FROM photos WHERE id = :itemId")
    fun fetchItemByItemId(itemId: Int): Flowable<PhotoItem>

    @Query("SELECT * FROM photos")
    fun fetchItems(): Flowable<List<PhotoItem>>

    @Update
    fun updateItem(photoItem: PhotoItem)

    @Delete
    fun deleteItem(photoItem: PhotoItem)
}
