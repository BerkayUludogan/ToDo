package com.berkayuludogan.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.berkayuludogan.todoapp.R
import com.berkayuludogan.todoapp.data.entity.Todo
import com.berkayuludogan.todoapp.databinding.CardDesignBinding
import com.berkayuludogan.todoapp.ui.screens.MainScreenDirections
import com.berkayuludogan.todoapp.ui.viewmodel.MainViewmodel
import com.google.android.material.snackbar.Snackbar

class TodoAdapter(
    private val mContext: Context,
    private val todoList: List<Todo>,
    private val viewModel: MainViewmodel,
) :
    RecyclerView.Adapter<TodoAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(val binding: CardDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)

    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val todo = todoList[position]
        val design = holder.binding

        design.todoText.text = todo.name
        design.cardViewTodo.setOnClickListener {
            val dataDetail = MainScreenDirections.toUpdateScreen(todo)
            it.findNavController().navigate(dataDetail)
        }
        design.imageViewClose.setOnClickListener {
            Snackbar.make(it, "Do you want to delete ${todo.name}?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.deleteTodo(todo.id)
                }.show()
        }
    }


    override fun getItemCount(): Int {
        return todoList.size
    }


}