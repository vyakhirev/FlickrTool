package ru.vyakhirev.flickrtool.data.model

import ru.vyakhirev.flickrtool.domain.Mapper
import ru.vyakhirev.flickrtool.domain.model.Photo

class PhotoMapper : Mapper<Photo, PhotoData> {
    override fun from(model: Photo): PhotoData {
        TODO("Not yet implemented")
    }

    override fun to(model: PhotoData): Photo {
        TODO("Not yet implemented")
    }
}
