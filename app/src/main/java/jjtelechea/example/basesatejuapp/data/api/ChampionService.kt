package jjtelechea.example.basesatejuapp.data.api

import jjtelechea.example.basesatejuapp.data.api.response.ChampionResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ChampionService {

    @GET("data/{locale}/champion.json")
    suspend fun getChampions(@Path("locale") locale: String): ChampionResponseDTO
}