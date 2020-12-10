package jjtelechea.example.basesatejuapp.data.database.dao

import androidx.room.*
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SatejuDao {

    companion object {
        const val TABLE_NAME = "sateju"
    }

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllSatejus(): Flow<SatejuEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun getSatejuWithId(id: Int): SatejuEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSatejus(vararg sateju: SatejuEntity)

    @Update
    suspend fun updateSatejus(vararg satejuEntity: SatejuEntity)

    @Delete
    suspend fun deleteSatejus(vararg sateju: SatejuEntity)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()
}