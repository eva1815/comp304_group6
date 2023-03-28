package com.example.group6.alexeva_comp304sec401_lab4_group6.model

import androidx.lifecycle.LiveData
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.BooksDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class BooksRepository(private val booksDao: BooksDao) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    // You can use LiveData instead and will notify the observer when there's a change

    // val allBooksFromDB : LiveData<List<Books>> = booksDao

}