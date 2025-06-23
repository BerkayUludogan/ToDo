package com.berkayuludogan.todoapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.berkayuludogan.todoapp.R
import com.berkayuludogan.todoapp.databinding.MainScreenBinding
import com.berkayuludogan.todoapp.ui.viewmodel.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : Fragment() {
    private lateinit var binding: MainScreenBinding
    private lateinit var viewModel: MainViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = MainScreenBinding.inflate(inflater, container, false)




        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.toSaveScreen)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewmodel: MainViewmodel by viewModels()
        viewModel = tempViewmodel
    }
}