package jjtelechea.example.basesatejuapp.ui.championFeature

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import jjtelechea.example.basesatejuapp.data.repository.ChampionRepository
import jjtelechea.example.basesatejuapp.domain.model.ChampionEntity
import javax.inject.Inject

@HiltViewModel
class ChampionListViewModel @Inject constructor(championRepository: ChampionRepository) :
    ViewModel() {

    val data: LiveData<List<ChampionEntity>> = championRepository.getAllChampions().asLiveData()
}
