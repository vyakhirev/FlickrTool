package ru.vyakhirev.flickrtool.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.domain.usecases.GetPhotoSearchUseCase

class ListPhotosViewModel @Inject
constructor(private val getPhotoSearchUseCase: GetPhotoSearchUseCase) : ViewModel() {
    private val disposable = CompositeDisposable()
    var page = 1
    var perPage = 30

    private val _photos = MutableLiveData<MutableList<PhotoItem>>()
    val photos: LiveData<MutableList<PhotoItem>> = _photos

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
