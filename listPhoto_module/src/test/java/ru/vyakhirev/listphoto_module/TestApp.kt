package ru.vyakhirev.listphoto_module

import android.content.Context
import org.mockito.Mockito
import ru.vyakhirev.core_api.database.DatabaseContract
import ru.vyakhirev.core_api.database.PhotoItemDao
import ru.vyakhirev.core_api.datasource.Repository
import ru.vyakhirev.core_api.mediator.BigPhotoMediator
import ru.vyakhirev.core_api.mediator.FavoritesPhotoMediator
import ru.vyakhirev.core_api.mediator.ListPhotoMediator
import ru.vyakhirev.flickrtool.App

//@Suppress("UNCHECKED_CAST")
//class TestApp :Application(),AppWithFacade  {
class TestApp : App() {

//    private val facade: ProvidersFacade

    val context: Context = Mockito.mock(Context::class.java)

    val listPhotoMediator: ListPhotoMediator = Mockito.mock(ListPhotoMediator::class.java)
    val favoritesPhotoMediator: FavoritesPhotoMediator =
        Mockito.mock(FavoritesPhotoMediator::class.java)
    val bigPhotoMediator: BigPhotoMediator = Mockito.mock(BigPhotoMediator::class.java)
    val appDb: DatabaseContract = Mockito.mock(DatabaseContract::class.java)
    val photoItemDao: PhotoItemDao = Mockito.mock(PhotoItemDao::class.java)
    val repository: Repository = Mockito.mock(Repository::class.java)

    override fun onCreate() {
        super.onCreate()
        setTheme(R.style.AppTheme)
//        DaggerTestAppComponent.create().inject(this)

    }

//    override fun getFacade(): ProvidersFacade {
//        return facade
//    }

//    init {
//        facade = object : ProvidersFacade {
//
//            override fun provideContext(): Context = context
//
//            override fun provideListPhotoMediator() : ListPhotoMediator=listPhotoMediator
//
//            override fun provideFavoritesPhotoMediator(): FavoritesPhotoMediator=favoritesPhotoMediator
//
//            override fun provideBigPhotoMediator(): BigPhotoMediator=bigPhotoMediator
//
//            override fun provideAppDb(): DatabaseContract=appDb
//
//            override fun providesPhotoDao(): PhotoItemDao=photoItemDao
//
//            override fun provideRepository(): Repository=repository
//        }
//    }
}
