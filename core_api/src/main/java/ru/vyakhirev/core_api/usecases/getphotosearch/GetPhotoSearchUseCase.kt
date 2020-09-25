package ru.vyakhirev.core_api.usecases.getphotosearch

import io.reactivex.Flowable
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_api.dto.PhotoResult
import javax.inject.Inject

class GetPhotoSearchUseCase @Inject
constructor(private val repository: Repository) {
    fun execute(query: String, page: Int, per_Page: Int): Flowable<PhotoResult> {
        return repository.getPhotoSearchResult(query, page, per_Page)
    }
}