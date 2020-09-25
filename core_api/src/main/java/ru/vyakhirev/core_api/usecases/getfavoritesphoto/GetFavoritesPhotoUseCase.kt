package ru.vyakhirev.core_api.usecases.getfavoritesphoto

import io.reactivex.Flowable
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.dto.PhotoResult
import javax.inject.Inject

class GetFavoritesPhotoUseCase @Inject
constructor(private val repository: Repository) {
    fun execute(): Flowable<List<PhotoItem>> {
        return repository.getFavorites()
    }
}