package ru.vyakhirev.flickrtool.domain.usecases

import io.reactivex.Completable
import io.reactivex.Flowable
import ru.vyakhirev.flickrtool.data.model.local.PhotoItem
import ru.vyakhirev.flickrtool.data.sources.repository.RepositoryImpl
import javax.inject.Inject

class GetFavoritesUseCase @Inject
constructor(private val repository: RepositoryImpl) {
    fun execute(): Flowable<List<PhotoItem>> {
        return repository.getFavorites()
    }
}