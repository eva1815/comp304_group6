package com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Librarian
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.DatabaseRepository
import kotlinx.coroutines.launch

class LibrarianViewModel(private val repository: DatabaseRepository): ViewModel() {
    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private val allLibrarian: LiveData<List<Librarian>> = repository.allLibrarianFromDB

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(librarian: Librarian) = viewModelScope.launch {
        repository.insert(librarian)
    }

    fun update(input: String, newInput: String){
        viewModelScope.launch {
//            for(p in allLibrarian.value!!){
//                if(p.name == input){
//                    p.name = newInput
//                    repository.update(p)
//                    println("${p.id} - ${p.name} - ${p.role}")
//                }
//            }
        }
    }

    fun delete(input: String){
        viewModelScope.launch {
            for(p in allLibrarian.value!!){
                if(p.librarianId == input){
                    repository.delete(p)
                }
            }
        }
    }

    fun getLibrarianById(id: String): LiveData<Librarian> {
        return repository.getLibrarianById(id)
    }


}