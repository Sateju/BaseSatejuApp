package jjtelechea.example.basesatejuapp.ui.satejuFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jjtelechea.example.basesatejuapp.R
import jjtelechea.example.basesatejuapp.databinding.FragmentSatejuBinding


class SatejuFragment : Fragment() {

    private lateinit var binding: FragmentSatejuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sateju, container, false)

        return binding.root
    }
}