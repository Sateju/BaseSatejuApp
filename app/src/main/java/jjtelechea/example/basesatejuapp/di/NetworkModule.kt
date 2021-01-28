package jjtelechea.example.basesatejuapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jjtelechea.example.basesatejuapp.data.api.SatejuService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    /*
    Example of how to use Qualifiers to have different implementations of the same class
     */
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BasicOkHttpInterceptor

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BodyOkHttpInterceptor

    @BasicOkHttpInterceptor
    @Provides
    fun provideBasicOkHttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    }

    @BodyOkHttpInterceptor
    @Provides
    fun provideBodyOkHttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Singleton
    @Provides
    fun provideRetrofit(@BasicOkHttpInterceptor interceptor: HttpLoggingInterceptor): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun provideSatejuService(retrofit: Retrofit): SatejuService {
        return retrofit.create(SatejuService::class.java)
    }
}