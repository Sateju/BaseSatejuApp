package jjtelechea.example.basesatejuapp.data.repository.impl

import jjtelechea.example.basesatejuapp.data.api.SatejuService
import jjtelechea.example.basesatejuapp.data.api.mapper.toSatejuPostEntity
import jjtelechea.example.basesatejuapp.data.database.dao.SatejuDao
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity
import jjtelechea.example.basesatejuapp.data.repository.SatejuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SatejuRepositoryImpl @Inject constructor(
    private val service: SatejuService,
    private val satejuDao: SatejuDao
) : SatejuRepository {

    override fun getAllPosts(): Flow<List<SatejuPostEntity>> = flow {

        emit(service.getPosts().map { it.toSatejuPostEntity() })
    }
}