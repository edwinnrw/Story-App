package id.edwinnurwansyah.telkomcase.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import id.edwinnurwansyah.telkomcase.data.api.RemoteApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {



    @Singleton
    @Provides
    internal fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()

    }
    @Singleton
    @Provides
    internal fun provideOkHttpClient(application: Application): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.connectTimeout(3,TimeUnit.MINUTES)
        httpClientBuilder.addInterceptor(interceptor)
        return httpClientBuilder.build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder().baseUrl("https://hacker-news.firebaseio.com/v0/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()

    }
    @Singleton
    @Provides
    internal fun provideApiService(retrofit: Retrofit) : RemoteApi {
        return retrofit.create(RemoteApi::class.java)
    }


}