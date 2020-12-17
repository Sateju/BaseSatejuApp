package jjtelechea.example.basesatejuapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import jjtelechea.example.basesatejuapp.data.database.dao.SatejuDao
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity

@Database(entities = [SatejuPostEntity::class], version = 1, exportSchema = false)
abstract class SatejuDatabase : RoomDatabase() {

    abstract fun getSatejuDao(): SatejuDao

    companion object {

        @Volatile private var instance: SatejuDatabase? = null

        fun getInstance(context: Context): SatejuDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
                    .also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): SatejuDatabase {
            return Room.databaseBuilder(context, SatejuDatabase::class.java, DATABASE_NAME).build()
        }
    }
}

private const val DATABASE_NAME = "sateju-db"