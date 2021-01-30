package jjtelechea.example.basesatejuapp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import jjtelechea.example.basesatejuapp.data.database.entity.ChampionDBEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ChampionDao : BaseDao<ChampionDBEntity> {

    companion object {
        const val TABLE_NAME = "champion"
    }

    @Query("SELECT * FROM $TABLE_NAME")
    abstract fun getAllChampions(): Flow<List<ChampionDBEntity>>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    abstract suspend fun getChampionById(id: String): ChampionDBEntity
}