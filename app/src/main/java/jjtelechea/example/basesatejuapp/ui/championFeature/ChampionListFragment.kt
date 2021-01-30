package jjtelechea.example.basesatejuapp.ui.championFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jjtelechea.example.basesatejuapp.databinding.FragmentChampionListBinding

@AndroidEntryPoint
class ChampionListFragment : Fragment() {

    private lateinit var binding: FragmentChampionListBinding

    private val viewModel: ChampionListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Get a reference to the binding object and inflate the fragment views.
        binding = FragmentChampionListBinding.inflate(inflater, container, false)

        // Specify the current activity as the lifecycle owner of the binding.
        // This is necessary so that the binding can observe LiveData updates.
        binding.lifecycleOwner = this

        // To use the View Model with data binding, you have to explicitly
        // give the binding object a reference to it.
        binding.viewModel = viewModel

        val adapter = ChampionAdapter()
        binding.championRecycler.adapter = adapter

        viewModel.data.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}