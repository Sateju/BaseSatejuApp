package jjtelechea.example.basesatejuapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import jjtelechea.example.basesatejuapp.data.api.ChampionService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    private const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/11.2.1/"

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

    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideRetrofit(@BodyOkHttpInterceptor interceptor: HttpLoggingInterceptor): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val contentType = "application/json".toMediaType()

        val jsonConverterFactory = Json { ignoreUnknownKeys = true }.asConverterFactory(contentType)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(jsonConverterFactory)
            .build()
    }

    @Provides
    fun provideChampionService(retrofit: Retrofit): ChampionService {
        return retrofit.create(ChampionService::class.java)
    }
}