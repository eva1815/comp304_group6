package com.example.group6.alexeva_comp304sec401_lab4_group6.viewModel

import android.app.Application
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.DatabaseRepository
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.db.BooksRoomDB
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.db.LibrarianRoomDB
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.db.StudentRoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibrarianApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val librarianDatabase by lazy { LibrarianRoomDB.getDatabase(this) }
    private val studentDatabase by lazy { StudentRoomDB.getDatabase(this) }
    private val booksDatabase by lazy { BooksRoomDB.getDatabase(this) }
    val repository by lazy { DatabaseRepository(librarianDatabase.librarianDao(), studentDatabase.studentDao(),booksDatabase.booksDao()) }

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.IO).launch {
//            librarianDatabase.addSomeDummyData()
        }
    }
}