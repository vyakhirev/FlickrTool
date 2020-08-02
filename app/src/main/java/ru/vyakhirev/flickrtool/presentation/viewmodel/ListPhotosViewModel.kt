package ru.vyakhirev.flickrtool.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyakhirev.flickrtool.BuildConfig
import ru.vyakhirev.flickrtool.data.RepositoryImpl
import ru.vyakhirev.flickrtool.data.model.Photo

class ListPhotosViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    var page = 1
    var perPage = 30

    var repository=RepositoryImpl()

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun getPhoto() {
        disposable.add(
            repository.getRecentPhoto(BuildConfig.FLICKR_API_KEY,page,perPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Log.d("kan", "Loshara= $it")
                        _photos.value = it.body()?.photos?.photo
                    }, {
                        Log.d("kan", "Mistake=$it")
                    }
                )
        )
    }
}
