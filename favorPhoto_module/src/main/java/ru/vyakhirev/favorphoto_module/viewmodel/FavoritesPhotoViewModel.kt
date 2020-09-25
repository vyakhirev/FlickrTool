package ru.vyakhirev.favorphoto_module.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.usecases.getfavoritesphoto.GetFavoritesPhotoUseCase
import ru.vyakhirev.core_api.usecases.getphotosearch.GetPhotoSearchUseCase
import ru.vyakhirev.core_api.usecases.switchFavoriteUseCase.SwitchFavoritesUseCase
import javax.inject.Inject

class FavoritesPhotoViewModel @Inject
constructor(
    private val getFavoritesPhotoUseCase: GetFavoritesPhotoUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase
) : ViewModel() {
    private val disposable = CompositeDisposable()
    var page = 1
    var perPage = 30

    private val _photos = MutableLiveData<List<PhotoItem>>()
    val photos: LiveData<List<PhotoItem>> = _photos

    fun switchFavorite(photoItem: PhotoItem) {
        disposable.add(
            switchFavoritesUseCase.execute(photoItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, { Log.d("kan", it.message.toString()) })
        )
    }

    fun getFavoritesPhoto(){
        disposable.add(
            getFavoritesPhotoUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _photos.value = it
                    }, {
                    }
                )
        )
    }

    override fun onCleared() {
        disposable.clear()
    }
}