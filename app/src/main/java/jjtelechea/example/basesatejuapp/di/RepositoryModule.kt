package jjtelechea.example.basesatejuapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jjtelechea.example.basesatejuapp.data.repository.SatejuRepository
import jjtelechea.example.basesatejuapp.data.repository.impl.SatejuRepositoryImpl

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindSatejuRepository(satejuRepositoryImpl: SatejuRepositoryImpl): SatejuRepository
}