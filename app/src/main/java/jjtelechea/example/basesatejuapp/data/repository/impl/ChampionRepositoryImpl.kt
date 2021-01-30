package jjtelechea.example.basesatejuapp.data.repository.impl

import jjtelechea.example.basesatejuapp.data.api.ChampionService
import jjtelechea.example.basesatejuapp.data.api.mapper.toChampionEntity
import jjtelechea.example.basesatejuapp.data.api.model.LanguageCode
import jjtelechea.example.basesatejuapp.data.repository.ChampionRepository
import jjtelechea.example.basesatejuapp.domain.model.ChampionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChampionRepositoryImpl @Inject constructor(
    private val service: ChampionService
) : ChampionRepository {

    override fun getAllChampions(): Flow<List<ChampionEntity>> = flow {
        val championResponse = service.getChampions(LanguageCode.SPANISH_SPAIN.value)
        emit(championResponse.data.map { it.toChampionEntity() })
    }
}