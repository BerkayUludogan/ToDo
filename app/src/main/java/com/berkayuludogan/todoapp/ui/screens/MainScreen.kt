package com.berkayuludogan.todoapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.berkayuludogan.todoapp.R
import com.berkayuludogan.todoapp.databinding.MainScreenBinding


class MainScreen : Fragment() {
    private lateinit var binding: MainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = MainScreenBinding.inflate(inflater, container, false)





        return binding.root
    }

}