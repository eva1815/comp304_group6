package com.example.group6.alexeva_comp304sec401_lab4_group6.application

import android.app.Application
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.DatabaseRepository
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val appDatabase by lazy { AppDatabase.getDatabase(this) }

    val repository by lazy { DatabaseRepository(appDatabase.librarianDao(),
        appDatabase.studentDao(),appDatabase.booksDao()) }

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.IO).launch {
//            librarianDatabase.addSomeDummyData()
        }

    }
}