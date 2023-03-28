package com.example.group6.alexeva_comp304sec401_lab4_group6.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Student
import com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao.StudentDao

// Annotates class to be a Room Database with a table (entity) of the Student class
@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentRoomDB: RoomDatabase(){

    abstract fun studentDao(): StudentDao

//always keep(copy) this code: it's about how you create your database
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: StudentRoomDB? = null

        fun getDatabase(context: Context): StudentRoomDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentRoomDB::class.java,
                    "word_database"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }
// adding dummy data

//suspend fun addSomeDummyData(){
//    val wordDao = wordDao()
//    wordDao.insert(Person(null, "Jack","Tester"))
//    wordDao.insert(Person(null,"Maya","Manager"))
//}

}