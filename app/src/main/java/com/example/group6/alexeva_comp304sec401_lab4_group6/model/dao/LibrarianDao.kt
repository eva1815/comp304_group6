package com.example.group6.alexeva_comp304sec401_lab4_group6.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.group6.alexeva_comp304sec401_lab4_group6.entity.Books

@Dao
interface LibrarianDao {

    //Librarian can also see all the books currently in the library (Viewing)
    @Query("SELECT * FROM books_table ORDER BY bookId ASC")
    fun getBooksFromDB(): LiveData<List<Books>>

   // Librarians to add books in the library
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(books: Books)

   // Librarians to update books in the library
    @Update
    suspend fun update(books: Books)

    //Librarians to remove books in the library
    @Delete
    suspend fun delete(books: Books)

}