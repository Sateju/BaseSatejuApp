package jjtelechea.example.basesatejuapp.data.repository

import jjtelechea.example.basesatejuapp.domain.model.ChampionEntity
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {

    fun getAllChampions(): Flow<List<ChampionEntity>>
}