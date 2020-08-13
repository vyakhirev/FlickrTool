package ru.vyakhirev.flickrtool.domain.usecases

import io.reactivex.Flowable
import javax.inject.Inject
import ru.vyakhirev.flickrtool.data.model.remote.PhotoResult
import ru.vyakhirev.flickrtool.data.sources.repository.RepositoryImpl

class GetPhotoSearchUseCase @Inject
constructor(private val repository: RepositoryImpl) {
    fun execute(query: String, page: Int, per_Page: Int): Flowable<PhotoResult> {
        return repository.getPhotoSearchResult(query, page, per_Page)
    }
}
