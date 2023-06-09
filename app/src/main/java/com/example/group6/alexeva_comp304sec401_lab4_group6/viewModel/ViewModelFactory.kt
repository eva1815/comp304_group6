package com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.DatabaseRepository



class ViewModelFactory(private val repository: DatabaseRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(LibrarianViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LibrarianViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}