package com.berkayuludogan.todoapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.berkayuludogan.todoapp.R
import com.berkayuludogan.todoapp.databinding.SaveScreenBinding
import com.berkayuludogan.todoapp.ui.viewmodel.SaveViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveScreen : Fragment() {
    private lateinit var binding: SaveScreenBinding
    private lateinit var viewModel: SaveViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = SaveScreenBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            viewModel.save(binding.editTextName.text.toString())
            Log.e("Save Result", "Tıklandı.")
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SaveViewmodel by viewModels()
        viewModel = tempViewModel
    }
}