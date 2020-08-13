package ru.vyakhirev.flickrtool.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.vyakhirev.flickrtool.BuildConfig
import ru.vyakhirev.flickrtool.data.sources.remote.FlickrApiService

@Module
class ApiModule {
    private val BASE_URL = "https://www.flickr.com"

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.FLICKR_API_KEY)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Not logging the authkey if not debug
    private val client =
        if (BuildConfig.DEBUG) {
            OkHttpClient().newBuilder()
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor)
                .build()
        }

    val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    fun provideFlickrApiService(): FlickrApiService {
        return retrofit.create(FlickrApiService::class.java)
    }

//    @Provides
//    @Singleton
//    internal fun providesNetworkService(retrofit: Retrofit): NetworkApiService {
//        return retrofit.create(NetworkApiService::class.java)
//    }

//    @Provides
//    @Singleton
//    open fun apiClient(): FlickrApiClient {
//        return FlickrApiClient()
//    }
}
