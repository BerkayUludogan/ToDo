package com.berkayuludogan.todoapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.berkayuludogan.todoapp.R
import com.berkayuludogan.todoapp.databinding.UpdateScreenBinding
import com.berkayuludogan.todoapp.ui.viewmodel.UpdateViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateScreen : Fragment() {
    private lateinit var binding: UpdateScreenBinding
    private lateinit var viewModel: UpdateViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = UpdateScreenBinding.inflate(inflater, container, false)
        val bundle: UpdateScreenArgs by navArgs()
        val todo = bundle.todo
        binding.updateScreenText.setText(todo.name)
        binding.updateButton.setOnClickListener {
            viewModel.updateName(todo.id, binding.updateScreenText.text.toString())
            it.findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewmodel: UpdateViewmodel by viewModels()
        viewModel = tempViewmodel
    }
}