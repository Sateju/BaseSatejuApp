package jjtelechea.example.basesatejuapp.ui.satejuFeature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import jjtelechea.example.basesatejuapp.data.repository.ChampionRepository
import jjtelechea.example.basesatejuapp.domain.model.ChampionEntity

class ChampionListViewModel @ViewModelInject constructor(championRepository: ChampionRepository) :
    ViewModel() {

    val data: LiveData<List<ChampionEntity>> = championRepository.getAllChampions().asLiveData()
}
