package com.project.fitness.ui.main.training.running

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.fitness.R
import com.project.fitness.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private var _binding: FragmentRunningBinding? = null
    private val binding get() = _binding as FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}