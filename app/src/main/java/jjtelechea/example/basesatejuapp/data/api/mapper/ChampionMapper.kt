package jjtelechea.example.basesatejuapp.data.api.mapper

import jjtelechea.example.basesatejuapp.data.api.response.ChampionDTO
import jjtelechea.example.basesatejuapp.domain.model.ChampionEntity

fun ChampionDTO.toChampionEntity() = ChampionEntity(
    name = name ?: "",
    title = title ?: ""
)