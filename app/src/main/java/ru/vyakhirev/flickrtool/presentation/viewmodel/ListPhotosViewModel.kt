package ru.vyakhirev.flickrtool.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.domain.usecases.GetPhotoSearchUseCase
import ru.vyakhirev.flickrtool.domain.usecases.SwitchFavoriteUseCase
import javax.inject.Inject

class ListPhotosViewModel @Inject
constructor(
    private val getPhotoSearchUseCase: GetPhotoSearchUseCase,
    private val switchFavoriteUseCase: SwitchFavoriteUseCase
) : ViewModel() {
    private val disposable = CompositeDisposable()
    var page = 1
    var perPage = 30

    private val _photos = MutableLiveData<MutableList<PhotoItem>>()
    val photos: LiveData<MutableList<PhotoItem>> = _photos

    fun switchFavorite(photoItem: PhotoItem) {
        disposable.add(
        switchFavoriteUseCase.execute(photoItem)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, { Log.d("kan", it.message.toString()) })
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
