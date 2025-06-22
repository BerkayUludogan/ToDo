package com.berkayuludogan.todoapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.berkayuludogan.todoapp.R
import com.berkayuludogan.todoapp.databinding.SaveScreenBinding


class SaveScreen : Fragment() {
    private lateinit var binding: SaveScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = SaveScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


}