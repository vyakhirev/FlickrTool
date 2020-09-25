package ru.vyakhirev.core_api.usecases.switchFavoriteUseCase

import io.reactivex.Completable
import io.reactivex.Flowable
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_api.dto.PhotoItem
import javax.inject.Inject

class SwitchFavoritesUseCase @Inject
constructor(private val repository: Repository) {
    fun execute(photoItem: PhotoItem): Completable {
        return repository.switchFavorite(photoItem)
    }
}