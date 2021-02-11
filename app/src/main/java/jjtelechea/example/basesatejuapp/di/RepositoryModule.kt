package jjtelechea.example.basesatejuapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import jjtelechea.example.basesatejuapp.data.repository.ChampionRepository
import jjtelechea.example.basesatejuapp.data.repository.impl.ChampionRepositoryImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindChampionRepository(championRepositoryImpl: ChampionRepositoryImpl): ChampionRepository
}