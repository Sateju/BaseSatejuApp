package jjtelechea.example.basesatejuapp.data.database.dao

import androidx.room.*
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SatejuDao {

    companion object {
        const val TABLE_NAME = "sateju"
    }

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllSatejuPosts(): Flow<List<SatejuPostEntity>>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun getSatejuPostWithId(id: Int): SatejuPostEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSatejuPosts(vararg satejuPosts: SatejuPostEntity)

    @Update
    suspend fun updateSatejuPosts(vararg satejuPosts: SatejuPostEntity)

    @Delete
    suspend fun deleteSatejuPosts(vararg satejuPosts: SatejuPostEntity)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()
}