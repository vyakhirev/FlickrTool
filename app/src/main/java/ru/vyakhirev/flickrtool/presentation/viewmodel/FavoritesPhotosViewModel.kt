package ru.vyakhirev.flickrtool.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.domain.usecases.GetFavoritesUseCase
import ru.vyakhirev.flickrtool.domain.usecases.SwitchFavoriteUseCase
import javax.inject.Inject

class FavoritesPhotosViewModel @Inject
constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val switchFavoriteUseCase: SwitchFavoriteUseCase
) : ViewModel() {

    private val _favPhotos = MutableLiveData<List<PhotoItem>>()
    val favPhotos: LiveData<List<PhotoItem>> = _favPhotos

    private val disposable = CompositeDisposable()

    fun switchFavorite(photoItem: PhotoItem) {
        disposable.add(
            switchFavoriteUseCase.execute(photoItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    Log.d("kan", it.message.toString())
                })
        )
    }

    fun getFavorites() {
        disposable.add(
            getFavoritesUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _favPhotos.value=it
                }, {
                    Log.d("kan", it.message.toString())
                })
        )
    }

    override fun onCleared() {
        disposable.clear()
    }
}
