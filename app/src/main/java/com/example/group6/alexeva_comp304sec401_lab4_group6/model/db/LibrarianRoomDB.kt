package com.example.group6.alexeva_comp304sec401_lab4_group6.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Librarian
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.LibrarianDao

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Librarian::class), version = 1, exportSchema = false)
abstract class LibrarianRoomDB: RoomDatabase(){

    abstract fun librarianDao(): LibrarianDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: LibrarianRoomDB? = null

        fun getDatabase(context: Context): LibrarianRoomDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibrarianRoomDB::class.java,
                    //change librarians to librarian to match all the name
                    "librarian_database"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

//    suspend fun addSomeDummyData(){
//        val librarianDao = librarianDao()
//        librarianDao.insert(Librarian("001", "Yash", "Sheth", "COMP304"))
//        librarianDao.insert(Librarian("007","James","Bond", "CasinoRoyale"))
//    }
}
