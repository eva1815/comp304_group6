package com.example.group6.alexeva_comp304sec401_lab4_group6.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.BooksDao


// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Books::class), version = 1, exportSchema = false)
abstract class BooksRoomDB:RoomDatabase(){

    abstract fun booksDao():BooksDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BooksRoomDB? = null

        fun getDatabase(context: Context): BooksRoomDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksRoomDB::class.java,
                    "books_database"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }
}
