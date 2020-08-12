package ru.vyakhirev.flickrtool.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.vyakhirev.flickrtool.presentation.viewmodel.ListPhotosViewModel

class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListPhotosViewModel() as T
    }
}
