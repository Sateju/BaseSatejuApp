package jjtelechea.example.basesatejuapp.data.repository

import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity
import kotlinx.coroutines.flow.Flow

interface SatejuRepository {

    fun getAllPosts(): Flow<List<SatejuPostEntity>>
}