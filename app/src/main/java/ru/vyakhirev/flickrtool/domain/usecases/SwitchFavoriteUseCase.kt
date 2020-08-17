package ru.vyakhirev.flickrtool.domain.usecases

import io.reactivex.Completable
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.sources.repository.RepositoryImpl
import javax.inject.Inject

class SwitchFavoriteUseCase @Inject
constructor(private val repository: RepositoryImpl) {
    fun execute(photoItem: PhotoItem): Completable {
        return repository.switchFavorite(photoItem)
    }
}
