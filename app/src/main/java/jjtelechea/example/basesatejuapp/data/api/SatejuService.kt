package jjtelechea.example.basesatejuapp.data.api

import jjtelechea.example.basesatejuapp.data.api.response.SatejuComment
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SatejuService {

    @GET("comments")
    fun getComments(@Query("postId") id: Int): List<SatejuComment>
}