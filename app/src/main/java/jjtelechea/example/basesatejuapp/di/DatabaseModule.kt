package jjtelechea.example.basesatejuapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jjtelechea.example.basesatejuapp.data.database.SatejuDatabase
import jjtelechea.example.basesatejuapp.data.database.dao.SatejuDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideSatejuDatabase(@ApplicationContext context: Context): SatejuDatabase {
        return SatejuDatabase.getInstance(context)
    }

    @Provides
    fun provideSatejuDao(satejuDatabase: SatejuDatabase): SatejuDao {
        return satejuDatabase.getSatejuDao()
    }
}