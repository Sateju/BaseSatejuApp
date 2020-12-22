package jjtelechea.example.basesatejuapp.ui.satejuFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jjtelechea.example.basesatejuapp.R
import jjtelechea.example.basesatejuapp.databinding.FragmentSatejuBinding

@AndroidEntryPoint
class SatejuFragment : Fragment() {

    private lateinit var binding: FragmentSatejuBinding

    private val satejuViewModel: SatejuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Get a reference to the binding object and inflate the fragment views.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sateju, container, false)

        // Specify the current activity as the lifecycle owner of the binding.
        // This is necessary so that the binding can observe LiveData updates.
        binding.lifecycleOwner = this

        // To use the View Model with data binding, you have to explicitly
        // give the binding object a reference to it.
        binding.satejuViewModel = satejuViewModel

        val adapter = SatejuPostAdapter()
        binding.satejuPostList.adapter = adapter

        satejuViewModel.data.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}