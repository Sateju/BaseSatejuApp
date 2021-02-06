package jjtelechea.example.basesatejuapp.data.api.mapper

import jjtelechea.example.basesatejuapp.data.api.response.ChampionDTO
import jjtelechea.example.basesatejuapp.domain.model.ChampionEntity

const val IMAGE_URL_PATH = "https://ddragon.leagueoflegends.com/cdn/11.3.1/img/champion/"

fun ChampionDTO.toChampionEntity() = ChampionEntity(
    name = name ?: "",
    title = title ?: "",
    imageUrl = "${IMAGE_URL_PATH}${image?.full}"
)