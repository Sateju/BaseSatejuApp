package jjtelechea.example.basesatejuapp.ui.satejuFeature

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import jjtelechea.example.basesatejuapp.data.database.entity.SatejuPostEntity
import jjtelechea.example.basesatejuapp.data.repository.SatejuRepository
import javax.inject.Inject

@HiltViewModel
class SatejuViewModel @Inject constructor(satejuRepository: SatejuRepository) :
    ViewModel() {

    val data: LiveData<List<SatejuPostEntity>> = satejuRepository.getAllPosts().asLiveData()
}
