package ru.vyakhirev.flickrtool.domain.usecases

import io.reactivex.Flowable
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.data.sources.repository.RepositoryImpl

class GetPhotoSearchUseCase(private val repository: RepositoryImpl) {
    fun execute(query: String, page: Int, per_Page: Int): Flowable<PhotoResult> {
        return repository.getPhotoSearchResult(query, page, per_Page)
    }
}
