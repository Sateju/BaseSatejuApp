package jjtelechea.example.basesatejuapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import jjtelechea.example.basesatejuapp.data.repository.SatejuRepository
import jjtelechea.example.basesatejuapp.data.repository.impl.SatejuRepositoryImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindSatejuRepository(satejuRepositoryImpl: SatejuRepositoryImpl): SatejuRepository
}