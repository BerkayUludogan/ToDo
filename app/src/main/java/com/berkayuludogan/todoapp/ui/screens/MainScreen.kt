package com.berkayuludogan.todoapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkayuludogan.todoapp.R
import com.berkayuludogan.todoapp.databinding.MainScreenBinding
import com.berkayuludogan.todoapp.ui.adapter.TodoAdapter
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
        binding.recyclerViewToDo.layoutManager = LinearLayoutManager(requireContext())
        viewModel.todoList.observe(viewLifecycleOwner) {
            val todoAdapter = TodoAdapter(requireContext(), it, viewModel)
            binding.recyclerViewToDo.adapter = todoAdapter
        }
        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.toSaveScreen)
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

        })





        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTodos()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewmodel: MainViewmodel by viewModels()
        viewModel = tempViewmodel
    }
}