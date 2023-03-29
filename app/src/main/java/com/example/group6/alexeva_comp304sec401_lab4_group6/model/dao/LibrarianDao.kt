package com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Librarian

@Dao
interface LibrarianDao {

    //Librarian can also see all the books currently in the library (Viewing)

    @Query("SELECT * FROM librarian_table ORDER BY librarianId ASC")
    fun getLibrarianFromDB(): LiveData<List<Librarian>>

   // Librarians to add books in the library
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(librarian: Librarian)

   // Librarians to update books in the library
    @Update
    suspend fun update(librarian: Librarian)

    //Librarians to remove books in the library
    @Delete
    suspend fun delete(librarian: Librarian)

    @Query("SELECT * FROM librarian_table WHERE librarianId = :id")
    fun getLibrarianById(id: String): LiveData<Librarian>

}