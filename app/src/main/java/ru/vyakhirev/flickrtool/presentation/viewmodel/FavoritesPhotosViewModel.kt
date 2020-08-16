package ru.vyakhirev.flickrtool.presentation.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import ru.vyakhirev.flickrtool.domain.usecases.GetPhotoSearchUseCase

class FavoritesPhotosViewModel @Inject
constructor(private val getPhotoSearchUseCase: GetPhotoSearchUseCase) : ViewModel() {
    // TODO: Implement the ViewModel
}
