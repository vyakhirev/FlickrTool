package ru.vyakhirev.flickrtool.data.sources.db

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem

@Dao
interface PhotoItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleItem(photoItem: PhotoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleItem(photoItemList: List<PhotoItem>): Completable

    @Query("SELECT * FROM photos WHERE id = :itemId")
    fun getItemByItemId(itemId: Int): Flowable<PhotoItem>

    @Query("SELECT * FROM photos WHERE isFavorite = :itemIsFavorite")
    fun getFavorites(itemIsFavorite:Boolean): Flowable<List<PhotoItem>>
//    @Query("SELECT * FROM photos WHERE Title like :query")
//    fun SearchPhotosByTitle(query: String): Flowable<List<PhotoItem>>
    @Query("SELECT * FROM photos ")
    fun SearchPhotosByTitle(): Flowable<List<PhotoItem>>

    @Query("SELECT * FROM photos")
    fun fetchItems(): Flowable<List<PhotoItem>>

    @Update
    fun updateItem(photoItem: PhotoItem): Completable

    @Delete
    fun deleteItem(photoItem: PhotoItem)
}
