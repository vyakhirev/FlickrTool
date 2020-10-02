package ru.vyakhirev.listphoto_module.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.usecases.getphotosearch.GetPhotoSearchUseCase
import ru.vyakhirev.core_api.usecases.switchFavoriteUseCase.SwitchFavoritesUseCase
import javax.inject.Inject

class ListPhotosViewModel @Inject
constructor(
    private val getPhotoSearchUseCase: GetPhotoSearchUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase
) : ViewModel() {
    var disposable = CompositeDisposable()
    var page = 1
    var perPage = 30

    private val _photos = MutableLiveData<MutableList<PhotoItem>>()
    val photos: LiveData<MutableList<PhotoItem>> = _photos

    fun switchFavorite(photoItem: PhotoItem) {
        disposable.add(
            switchFavoritesUseCase.execute(photoItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, { })
        )
    }

    fun getPhoto(query: String) {
        disposable.add(
            getPhotoSearchUseCase.execute(query, page, perPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _photos.value = it.photo
                    }, {
                    }
                )
        )
    }

    override fun onCleared() {
        disposable.clear()
    }
}
