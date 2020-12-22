package jjtelechea.example.basesatejuapp.ui.satejuFeature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity
import jjtelechea.example.basesatejuapp.data.repository.SatejuRepository


class SatejuViewModel @ViewModelInject constructor(satejuRepository: SatejuRepository) :
    ViewModel() {

    val data: LiveData<List<SatejuPostEntity>> = satejuRepository.getAllPosts().asLiveData()
}
