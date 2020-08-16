package ru.vyakhirev.flickrtool.data.sources.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Flowable
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

@Dao
interface PhotoItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleItem(photoItem: PhotoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleItem(photoItemList: List<PhotoItem>)

    @Query("SELECT * FROM photos WHERE id = :itemId")
    fun fetchItemByItemId(itemId: Int): Flowable<PhotoItem>

    @Query("SELECT * FROM photos WHERE Title like :query")
    fun SearchPhotosByTitle(query: String): Flowable<PhotoItem>

    @Query("SELECT * FROM photos")
    fun fetchItems(): Flowable<List<PhotoItem>>

    @Update
    fun updateItem(photoItem: PhotoItem)

    @Delete
    fun deleteItem(photoItem: PhotoItem)
}
