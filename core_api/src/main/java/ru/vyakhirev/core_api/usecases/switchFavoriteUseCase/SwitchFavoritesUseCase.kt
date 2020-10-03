package ru.vyakhirev.core_api.usecases.switchFavoriteUseCase

import io.reactivex.Completable
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_api.dto.PhotoItem
import javax.inject.Inject

open class SwitchFavoritesUseCase @Inject
constructor(private val repository: Repository) {
    open fun execute(photoItem: PhotoItem): Completable {
        return repository.switchFavorite(photoItem)
    }
}