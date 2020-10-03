package ru.vyakhirev.listphoto_module.viewmodel

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_api.dto.PhotoItem
import ru.vyakhirev.core_api.dto.PhotoResult
import ru.vyakhirev.core_api.usecases.getphotosearch.GetPhotoSearchUseCase
import ru.vyakhirev.core_api.usecases.switchFavoriteUseCase.SwitchFavoritesUseCase
import ru.vyakhirev.listphoto_module.utils.DataGenerator
import ru.vyakhirev.listphoto_module.utils.RxRule


class ListPhotosViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val rxRule: RxRule = RxRule()

    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var getPhotoSearchUseCase: GetPhotoSearchUseCase

    @Mock
    lateinit var switchFavoritesUseCase: SwitchFavoritesUseCase

    lateinit var listPhotosViewModel: ListPhotosViewModel

    private lateinit var dummyList: List<PhotoItem>
    private lateinit var dummyPhotoResult: PhotoResult

    @Before
    fun setUp() {
        dummyList = DataGenerator.getDummyGalleryList(85)
        dummyPhotoResult = PhotoResult(1, 3, 30, 90, dummyList as MutableList<PhotoItem>)
        listPhotosViewModel = ListPhotosViewModel(getPhotoSearchUseCase, switchFavoritesUseCase)
    }

    @Test
    fun switchFavorite() {
        val photoItem = dummyList[0]
        photoItem.isFavorite = !photoItem.isFavorite
        Mockito.`when`(switchFavoritesUseCase.execute(photoItem))
            .thenReturn(Completable.complete())
        assertEquals(true, photoItem.isFavorite)
    }

    @Test
    fun getPhotosMy() {
        val expected = dummyPhotoResult
        Mockito.`when`(getPhotoSearchUseCase.execute("Moon", 1, 30))
            .thenReturn(Flowable.just(expected))

        getPhotoSearchUseCase.execute("Moon", 1, 30)
            .test()
            .assertResult(expected)
            .assertNoErrors()
    }

    @Test
    fun compositeDisposableCleared() {
        val d = CompositeDisposable()
        listPhotosViewModel.disposable = d

        assertEquals(0, listPhotosViewModel.disposable.size())

        d.add(Observable.just("").subscribe())
        assertEquals(1, listPhotosViewModel.disposable.size())

        d.clear()

        assertEquals(0, listPhotosViewModel.disposable.size())
    }

}

