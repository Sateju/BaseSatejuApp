package jjtelechea.example.basesatejuapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jjtelechea.example.basesatejuapp.data.repository.ChampionRepository
import jjtelechea.example.basesatejuapp.data.repository.impl.ChampionRepositoryImpl

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindChampionRepository(championRepositoryImpl: ChampionRepositoryImpl): ChampionRepository
}