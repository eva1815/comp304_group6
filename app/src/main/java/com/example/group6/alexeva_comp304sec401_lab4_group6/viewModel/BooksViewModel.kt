package com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.BooksRepository

class BooksViewModel(private val repository: BooksRepository):ViewModel() {
    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.

   // val allBooksFromDB : LiveData<List<Books>> = repository.

}